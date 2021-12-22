package com.redeyefrog.process;

import com.redeyefrog.constants.Properties;
import com.redeyefrog.dto.base.CommonHeader;
import com.redeyefrog.dto.base.CommonResponse;
import com.redeyefrog.enums.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ExceptionProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Exception e = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);

        log.error(e.getMessage(), e);

        CommonHeader header = exchange.getProperty(Properties.COMMON_HEADER, CommonHeader.class);
        header.setReturnCode(StatusCode.UNKNOWN.getCode());
        header.setReturnDesc(StatusCode.UNKNOWN.getDesc());

        CommonResponse<Object> response = new CommonResponse<>();
        response.setCommonHeader(header);
        response.setTranRs(new Object());

        exchange.getIn().setBody(response);
    }

}
