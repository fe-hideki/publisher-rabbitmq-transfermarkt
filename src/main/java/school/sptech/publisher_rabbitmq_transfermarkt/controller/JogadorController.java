package school.sptech.publisher_rabbitmq_transfermarkt.controller;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.publisher_rabbitmq_transfermarkt.domain.jogador.Jogador;
import school.sptech.publisher_rabbitmq_transfermarkt.dto.JogadorRequest;
import school.sptech.publisher_rabbitmq_transfermarkt.service.JogadorService;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    private final JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @GetMapping
    public List<Jogador> listar() {
        return jogadorService.listarJogadores();
    }

    @PostMapping
    public ResponseEntity<Jogador> criar(@Valid @RequestBody JogadorRequest request) {
        Jogador jogador = jogadorService.salvarJogador(request);
        return ResponseEntity.status(201).body(jogador);
    }
}
