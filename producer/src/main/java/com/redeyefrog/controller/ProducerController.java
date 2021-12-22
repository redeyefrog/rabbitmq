package com.redeyefrog.controller;

import com.redeyefrog.constants.Routes;
import com.redeyefrog.dto.base.CommonRequest;
import com.redeyefrog.dto.base.CommonResponse;
import com.redeyefrog.dto.user.UserInfoRq;
import com.redeyefrog.scope.RequestContext;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.FluentProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/produces")
@RestController
public class ProducerController {

    @Autowired
    private CamelContext camelContext;

    @Autowired
    private RequestContext requestContext;

    @PostMapping(value = "/send", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse<?> send(@RequestBody CommonRequest<UserInfoRq> request) {
        requestContext.setHeader(request.getHeader());

        FluentProducerTemplate fluentProducer = camelContext.createFluentProducerTemplate();

        Exchange exchange = fluentProducer.to(Routes.SEND_RABBITMQ).withBody(request).send();

        return exchange.getIn().getBody(CommonResponse.class);
    }

}
