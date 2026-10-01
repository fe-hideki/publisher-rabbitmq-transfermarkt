package school.sptech.publisher_rabbitmq_transfermarkt.controller;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.publisher_rabbitmq_transfermarkt.domain.transferencia.Transferencia;
import school.sptech.publisher_rabbitmq_transfermarkt.dto.TransferenciaRequest;
import school.sptech.publisher_rabbitmq_transfermarkt.service.TransferenciaService;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

    private final TransferenciaService transferenciaService;

    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @GetMapping
    public List<Transferencia> listar() {
        return transferenciaService.listarTransferencias();
    }

    @PostMapping
    public ResponseEntity<Transferencia> registrar(@Valid @RequestBody TransferenciaRequest request) {
        Transferencia transferencia = transferenciaService.registrarTransferencia(request);
        return ResponseEntity.status(201).body(transferencia);
    }
}
