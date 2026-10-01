package school.sptech.publisher_rabbitmq_transfermarkt.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class
RabbitConfig {

    public static final String EXCHANGE_TRANSFERENCIA = "transfermarkt.exchange";
    public static final String QUEUE_TRANSFERENCIA = "transfermarkt.transferencia.queue";
    public static final String ROUTING_KEY_TRANSFERENCIA = "transfermarkt.transferencia";

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE_TRANSFERENCIA);
    }

    @Bean
    public Queue queue() {
        return QueueBuilder
                .durable(QUEUE_TRANSFERENCIA)
                .build();
    }

    @Bean
    public Binding binding(
            Queue queue,
            DirectExchange exchange
    ) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(ROUTING_KEY_TRANSFERENCIA);
    }

    @Bean
    public JacksonJsonMessageConverter jsonMessageConverter() {
        return new JacksonJsonMessageConverter ();
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        rabbitAdmin.setAutoStartup(true);
        rabbitAdmin.initialize();
        return rabbitAdmin;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }
}
