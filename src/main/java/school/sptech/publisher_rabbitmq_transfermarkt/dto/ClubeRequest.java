package school.sptech.publisher_rabbitmq_transfermarkt.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClubeRequest(
        @NotBlank(message = "O nome do clube é obrigatório.") String nome,
        @NotBlank(message = "A cidade do clube é obrigatória.") String cidade,
        @NotBlank(message = "O país do clube é obrigatório.") String pais,
        @NotNull(message = "O ano de fundação é obrigatório.") @Min(value = 1800, message = "O ano de fundação deve ser válido.") Integer fundacao
) {
}
