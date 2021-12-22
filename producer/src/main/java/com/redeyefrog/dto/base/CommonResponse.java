package com.redeyefrog.dto.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class CommonResponse<S> implements Serializable {

    @JsonProperty("HEADER")
    private CommonHeader commonHeader;

    @JsonProperty("RS")
    private S tranRs;

}
