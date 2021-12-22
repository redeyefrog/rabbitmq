package com.redeyefrog.handler;

import com.redeyefrog.dto.base.CommonHeader;
import com.redeyefrog.dto.base.CommonResponse;
import com.redeyefrog.enums.StatusCode;
import com.redeyefrog.scope.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private RequestContext requestContext;

    @ExceptionHandler(Exception.class)
    public CommonResponse onException(Exception e) {
        log.error(e.getMessage(), e);

        CommonResponse response = new CommonResponse();

        CommonHeader header = requestContext.getHeader();
        if(header == null) {
            header = new CommonHeader();
        }
        header.setReturnCode(StatusCode.UNKNOWN.getCode());
        header.setReturnDesc(StatusCode.UNKNOWN.getDesc());

        response.setCommonHeader(header);
        response.setTranRs(new Object());

        return response;
    }

}
