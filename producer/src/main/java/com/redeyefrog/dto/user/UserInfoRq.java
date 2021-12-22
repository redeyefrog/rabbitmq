package com.redeyefrog.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfoRq implements Serializable {

    @JsonProperty("USER_ID")
    private String id;

    @JsonProperty("USER_NAME")
    private String name;

    @JsonProperty("USER_AGE")
    private Integer age;

    @JsonProperty("USER_PHONE")
    private String phone;

    @JsonProperty("USER_EMAIL")
    private String email;

}
