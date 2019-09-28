package com.flprojects.urlshortener.domain.errors;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WrongFormat {

    @JsonProperty("error")
    private final String ERROR = "Wrong Format";

    public String getERROR() {
        return ERROR;
    }
}
