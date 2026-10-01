package school.sptech.publisher_rabbitmq_transfermarkt.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import school.sptech.publisher_rabbitmq_transfermarkt.config.RabbitConfig;

@Component
public class TransferenciaProducer {

    private final RabbitTemplate rabbitTemplate;

    public TransferenciaProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarTransferencia(TransferenciaMessage mensagem) {
        rabbitTemplate.convertAndSend(
                RabbitConfig.EXCHANGE_TRANSFERENCIA,
                RabbitConfig.ROUTING_KEY_TRANSFERENCIA,
                mensagem
        );
    }
}
