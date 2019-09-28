package com.flprojects.urlshortener.domain.errors;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InvalidUrl {

    @JsonProperty("error")
    private final String ERROR = "invalid URL";

    public String getError() {
        return ERROR;
    }
}
