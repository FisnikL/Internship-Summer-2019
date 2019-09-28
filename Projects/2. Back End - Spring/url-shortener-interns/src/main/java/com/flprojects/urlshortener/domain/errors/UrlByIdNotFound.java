package com.flprojects.urlshortener.domain.errors;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UrlByIdNotFound {

    @JsonProperty("error")
    private final String ERROR = "No short url found for given input";

    public String getERROR() {
        return ERROR;
    }
}
