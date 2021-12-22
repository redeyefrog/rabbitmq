package com.redeyefrog.process;

import com.redeyefrog.constants.Properties;
import com.redeyefrog.dto.base.CommonHeader;
import com.redeyefrog.dto.base.CommonResponse;
import com.redeyefrog.enums.StatusCode;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class ReturnProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        CommonHeader header = exchange.getProperty(Properties.COMMON_HEADER, CommonHeader.class);
        header.setReturnCode(StatusCode.SUCCESS.getCode());
        header.setReturnDesc(StatusCode.SUCCESS.getDesc());

        CommonResponse<Object> response = new CommonResponse<>();
        response.setCommonHeader(header);
        response.setTranRs(new Object());

        exchange.getIn().setBody(response);
    }

}
