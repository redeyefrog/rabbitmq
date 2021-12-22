package com.redeyefrog.scope;

import com.redeyefrog.dto.base.CommonHeader;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
@Data
public class RequestContext {

    private CommonHeader header;

}
