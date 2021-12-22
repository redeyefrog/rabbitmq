package com.redeyefrog.process;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.redeyefrog.constants.Properties;
import com.redeyefrog.dto.base.CommonRequest;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Object2JsonProcessor implements Processor {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void process(Exchange exchange) throws Exception {
        CommonRequest<?> request = exchange.getIn().getBody(CommonRequest.class);

        exchange.setProperty(Properties.COMMON_HEADER, request.getHeader());

        String json = objectMapper.writeValueAsString(request);

        exchange.getIn().setBody(json);
    }

}
