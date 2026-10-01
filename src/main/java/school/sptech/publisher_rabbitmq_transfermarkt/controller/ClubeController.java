package school.sptech.publisher_rabbitmq_transfermarkt.controller;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.publisher_rabbitmq_transfermarkt.domain.clube.Clube;
import school.sptech.publisher_rabbitmq_transfermarkt.dto.ClubeRequest;
import school.sptech.publisher_rabbitmq_transfermarkt.service.ClubeService;

@RestController
@RequestMapping("/clubes")
public class ClubeController {

    private final ClubeService clubeService;

    public ClubeController(ClubeService clubeService) {
        this.clubeService = clubeService;
    }

    @GetMapping
    public List<Clube> listar() {
        return clubeService.listarClubes();
    }

    @PostMapping
    public ResponseEntity<Clube> criar(@Valid @RequestBody ClubeRequest request) {
        Clube clube = clubeService.salvarClube(request);
        return ResponseEntity.status(201).body(clube);
    }
}
