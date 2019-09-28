package com.flprojects.urlshortener.repository;

import com.flprojects.urlshortener.domain.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlShortenerRepository extends JpaRepository<Url, Long> {

}
