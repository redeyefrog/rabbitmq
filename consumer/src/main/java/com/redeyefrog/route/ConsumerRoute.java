package com.redeyefrog.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ConsumerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("rabbitmq:amq.topic?exchangeType=topic&queue=rabbit&autoDelete=false")
                .routeId("rabbitmq_consumer")
                .log("${body}");
    }

}
