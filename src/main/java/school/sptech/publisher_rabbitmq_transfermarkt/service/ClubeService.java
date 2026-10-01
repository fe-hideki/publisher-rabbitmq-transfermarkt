package school.sptech.publisher_rabbitmq_transfermarkt.service;

import java.util.List;
import org.springframework.stereotype.Service;
import school.sptech.publisher_rabbitmq_transfermarkt.domain.clube.Clube;
import school.sptech.publisher_rabbitmq_transfermarkt.domain.clube.ClubeRepository;
import school.sptech.publisher_rabbitmq_transfermarkt.dto.ClubeRequest;

@Service
public class ClubeService {

    private final ClubeRepository clubeRepository;

    public ClubeService(ClubeRepository clubeRepository) {
        this.clubeRepository = clubeRepository;
    }

    public List<Clube> listarClubes() {
        return clubeRepository.findAll();
    }

    public Clube salvarClube(ClubeRequest request) {
        Clube clube = new Clube(
                request.nome(),
                request.cidade(),
                request.pais(),
                request.fundacao()
        );

        return clubeRepository.save(clube);
    }
}
