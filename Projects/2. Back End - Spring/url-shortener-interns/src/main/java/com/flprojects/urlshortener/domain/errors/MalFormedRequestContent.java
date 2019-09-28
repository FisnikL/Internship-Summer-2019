package com.flprojects.urlshortener.domain.errors;

public class MalFormedRequestContent {
    private final String ERROR = "Request should be JSON format with one property 'url'";

    public String getERROR() {
        return ERROR;
    }
}
