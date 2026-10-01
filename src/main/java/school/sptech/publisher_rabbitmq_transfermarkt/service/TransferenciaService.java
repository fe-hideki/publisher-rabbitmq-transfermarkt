package school.sptech.publisher_rabbitmq_transfermarkt.service;

import java.util.List;
import org.springframework.stereotype.Service;
import school.sptech.publisher_rabbitmq_transfermarkt.domain.clube.Clube;
import school.sptech.publisher_rabbitmq_transfermarkt.domain.clube.ClubeRepository;
import school.sptech.publisher_rabbitmq_transfermarkt.domain.jogador.Jogador;
import school.sptech.publisher_rabbitmq_transfermarkt.domain.jogador.JogadorRepository;
import school.sptech.publisher_rabbitmq_transfermarkt.domain.transferencia.Transferencia;
import school.sptech.publisher_rabbitmq_transfermarkt.domain.transferencia.TransferenciaRepository;
import school.sptech.publisher_rabbitmq_transfermarkt.dto.TransferenciaRequest;
import school.sptech.publisher_rabbitmq_transfermarkt.rabbitmq.TransferenciaMessage;
import school.sptech.publisher_rabbitmq_transfermarkt.rabbitmq.TransferenciaProducer;

@Service
public class TransferenciaService {

    private final TransferenciaRepository transferenciaRepository;
    private final JogadorRepository jogadorRepository;
    private final ClubeRepository clubeRepository;
    private final TransferenciaProducer transferenciaProducer;

    public TransferenciaService(TransferenciaRepository transferenciaRepository,
                               JogadorRepository jogadorRepository,
                               ClubeRepository clubeRepository,
                               TransferenciaProducer transferenciaProducer) {
        this.transferenciaRepository = transferenciaRepository;
        this.jogadorRepository = jogadorRepository;
        this.clubeRepository = clubeRepository;
        this.transferenciaProducer = transferenciaProducer;
    }

    public List<Transferencia> listarTransferencias() {
        return transferenciaRepository.findAll();
    }

    public Transferencia registrarTransferencia(TransferenciaRequest request) {
        Jogador jogador = jogadorRepository.findById(request.jogadorId())
                .orElseThrow(() -> new IllegalArgumentException("Jogador não encontrado."));

        Clube clubeOrigem = clubeRepository.findById(request.clubeOrigemId())
                .orElseThrow(() -> new IllegalArgumentException("Clube de origem não encontrado."));

        Clube clubeDestino = clubeRepository.findById(request.clubeDestinoId())
                .orElseThrow(() -> new IllegalArgumentException("Clube de destino não encontrado."));

        if (jogador.getClube() == null || !jogador.getClube().getId().equals(clubeOrigem.getId())) {
            throw new IllegalArgumentException("O jogador não pertence ao clube de origem informado.");
        }

        if (clubeOrigem.getId().equals(clubeDestino.getId())) {
            throw new IllegalArgumentException("O clube de origem e o clube de destino devem ser diferentes.");
        }

        jogador.setClube(clubeDestino);
        jogadorRepository.save(jogador);

        Transferencia transferencia = new Transferencia(
                jogador,
                clubeOrigem,
                clubeDestino,
                request.valorTransferencia(),
                request.dataTransferencia()
        );

        Transferencia transferenciaSalva = transferenciaRepository.save(transferencia);

        TransferenciaMessage mensagem = new TransferenciaMessage(
                jogador.getId(),
                jogador.getNome(),
                clubeOrigem.getNome(),
                clubeDestino.getNome(),
                request.valorTransferencia(),
                request.dataTransferencia()
        );

        transferenciaProducer.enviarTransferencia(mensagem);

        return transferenciaSalva;
    }
}
