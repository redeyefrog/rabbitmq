package com.redeyefrog.route;

import com.redeyefrog.constants.Routes;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ProducerRoute extends RouteBuilder {



    @Override
    public void configure() throws Exception {
        onException(Exception.class)
                .handled(true)
                .process("exceptionProcessor");

        from("timer:produce?fixedRate=true&period=60000")
                .routeId("timer_producer")
                .setBody(simple("Hello World at ${header.firedTime}"))
                .to("rabbitmq:amq.topic?exchangeType=topic&queue=rabbit&autoDelete=false")
                .log("Fire Time: ${header.firedTime}");

        from(Routes.SEND_RABBITMQ)
                .routeId("send_producer")
                .process("object2JsonProcessor")
                .to("rabbitmq:amq.topic?exchangeType=topic&queue=rabbit&autoDelete=false")
                .log("Fire Request body: ${body}")
                .process("returnProcessor");
    }

}
