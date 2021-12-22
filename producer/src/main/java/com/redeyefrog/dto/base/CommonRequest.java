package com.redeyefrog.dto.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class CommonRequest<Q> implements Serializable {

    @JsonProperty("HEADER")
    private CommonHeader header;

    @JsonProperty("RQ")
    private Q tranRq;

}
