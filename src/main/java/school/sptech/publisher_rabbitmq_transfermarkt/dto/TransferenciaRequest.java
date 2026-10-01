package school.sptech.publisher_rabbitmq_transfermarkt.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public record TransferenciaRequest(
        @NotNull(message = "O ID do jogador é obrigatório.") Long jogadorId,
        @NotNull(message = "O ID do clube de origem é obrigatório.") Long clubeOrigemId,
        @NotNull(message = "O ID do clube de destino é obrigatório.") Long clubeDestinoId,
        @NotNull(message = "O valor da transferência é obrigatório.") @DecimalMin(value = "0.00", inclusive = true, message = "O valor da transferência não pode ser negativo.") BigDecimal valorTransferencia,
        @NotNull(message = "A data da transferência é obrigatória.") LocalDate dataTransferencia
) {
}
