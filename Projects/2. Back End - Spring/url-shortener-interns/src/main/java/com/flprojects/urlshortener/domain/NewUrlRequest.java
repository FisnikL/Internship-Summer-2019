package com.flprojects.urlshortener.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class NewUrlRequest {
    @NotEmpty
    @NotNull
    private String url;

    /*
        We need default constructor for Jackson JSON converting
     */
    public NewUrlRequest(){

    }

    public NewUrlRequest(@NotEmpty @NotNull String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "{" +
                "url='" + url + '\'' +
                '}';
    }
}
