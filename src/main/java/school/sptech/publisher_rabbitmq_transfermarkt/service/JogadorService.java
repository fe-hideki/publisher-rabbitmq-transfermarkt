package school.sptech.publisher_rabbitmq_transfermarkt.service;

import java.util.List;
import org.springframework.stereotype.Service;
import school.sptech.publisher_rabbitmq_transfermarkt.domain.clube.Clube;
import school.sptech.publisher_rabbitmq_transfermarkt.domain.clube.ClubeRepository;
import school.sptech.publisher_rabbitmq_transfermarkt.domain.jogador.Jogador;
import school.sptech.publisher_rabbitmq_transfermarkt.domain.jogador.JogadorRepository;
import school.sptech.publisher_rabbitmq_transfermarkt.dto.JogadorRequest;

@Service
public class JogadorService {

    private final JogadorRepository jogadorRepository;
    private final ClubeRepository clubeRepository;

    public JogadorService(JogadorRepository jogadorRepository, ClubeRepository clubeRepository) {
        this.jogadorRepository = jogadorRepository;
        this.clubeRepository = clubeRepository;
    }

    public List<Jogador> listarJogadores() {
        return jogadorRepository.findAll();
    }

    public Jogador salvarJogador(JogadorRequest request) {
        Clube clube = clubeRepository.findById(request.clubeId())
                .orElseThrow(() -> new IllegalArgumentException("Clube não encontrado."));

        Jogador jogador = new Jogador(
                request.nome(),
                request.posicao(),
                request.idade(),
                request.valorMercado(),
                clube
        );

        return jogadorRepository.save(jogador);
    }
}
