package com.flprojects.urlshortener.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "urls_table")
public class Url{

    @Id
    @Column(name = "short_url")
    private Long short_url_id;

    @Column(name = "original_url")
    private String original_url;

    /*
        Default constructor is needed for instantiating the entity
     */
    public Url(){

    }

    public Url(long short_url_id, String original_url) {
        this.original_url = original_url;
        this.short_url_id = short_url_id;
    }

    public String getOriginal_url() {
        return original_url;
    }

    public Long getShort_url_id() {
        return short_url_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Url)) return false;
        Url url = (Url) o;
        return (short_url_id.equals(url.short_url_id)) &&
                original_url.equals(url.original_url);
    }
}
