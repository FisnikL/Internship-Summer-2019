package com.flprojects.urlshortener.service;

import com.flprojects.urlshortener.domain.ShortUrl;
import com.flprojects.urlshortener.domain.Url;
import com.flprojects.urlshortener.repository.UrlShortenerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

@Service
public class UrlShortenerService {

    static final Logger logger = LoggerFactory.getLogger(UrlShortenerService.class);

    private UrlShortenerRepository repository;
    private ShortUrl shortUrlService;


    public UrlShortenerService(
            UrlShortenerRepository repository,
            ShortUrl shortUrlService
    ) {
        this.repository = repository;
        this.shortUrlService = shortUrlService;
    }

    public Optional<Url> createShortUrl(String url){
        if(isUrlValid(url)){
            long id = shortUrlService.shortURLtoID();
            Url validUrl = new Url(id, url);
            logger.info("Saving short url [{}]", validUrl);
            repository.save(validUrl);
            return Optional.of(validUrl);
        }else{
            return Optional.empty();
        }
    }

    public Optional<Url> getShortUrlById(Long id){
        return repository.findById(id);
    }

    public boolean isUrlValid(String url){
        int code = -1;
        try{
            URL siteURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(3000);
            connection.connect();

            code = connection.getResponseCode();

            if(code < 400){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }
}
