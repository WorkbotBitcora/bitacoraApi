package co.uco.bitacora.rabbitMQ;

import co.uco.bitacora.domain.revision.Revision;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@EnableRabbit
@AllArgsConstructor
@Component
public class Publicador {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private DirectExchange exchange;


    public String publicarColaA(Revision revisiones) {
        System.out.println("intenta publicarColaA");
        rabbitTemplate.convertAndSend(exchange.getName(), "routing.A" , revisiones);
        return "Revision enviada";
    }

    public String publicarColaC(long operacion){
        System.out.println( "va a publicar en c " + operacion) ;
        rabbitTemplate.convertAndSend(exchange.getName(), "routing.C" , operacion);
        return "Operacion enviada";
    }


}
