package com.redeyefrog.dto.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonHeader {

    @JsonProperty("REF_SEQ")
    private String refSeq;

    @JsonProperty("RETURN_CODE")
    private String returnCode;

    @JsonProperty("RETURN_DESC")
    private String returnDesc;

}
