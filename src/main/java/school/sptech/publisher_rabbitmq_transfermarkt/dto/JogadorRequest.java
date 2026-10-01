package school.sptech.publisher_rabbitmq_transfermarkt.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record JogadorRequest(
        @NotBlank(message = "O nome do jogador é obrigatório.") String nome,
        @NotBlank(message = "A posição do jogador é obrigatória.") String posicao,
        @NotNull(message = "A idade do jogador é obrigatória.") @Min(value = 15, message = "A idade deve ser maior ou igual a 15 anos.") Integer idade,
        @NotNull(message = "O valor de mercado é obrigatório.") @DecimalMin(value = "0.00", inclusive = true, message = "O valor de mercado não pode ser negativo.") BigDecimal valorMercado,
        @NotNull(message = "O clube do jogador é obrigatório.") Long clubeId
) {
}
