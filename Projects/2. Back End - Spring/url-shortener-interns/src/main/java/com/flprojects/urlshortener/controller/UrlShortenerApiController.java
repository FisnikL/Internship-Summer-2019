package com.flprojects.urlshortener.controller;

import com.flprojects.urlshortener.domain.errors.InvalidUrl;
import com.flprojects.urlshortener.domain.errors.MalFormedRequestContent;
import com.flprojects.urlshortener.domain.errors.UrlByIdNotFound;
import com.flprojects.urlshortener.domain.errors.WrongFormat;
import com.flprojects.urlshortener.domain.*;
import com.flprojects.urlshortener.service.UrlShortenerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/shorturl")
public class UrlShortenerApiController {
    private UrlShortenerService urlShortenerService;

    public UrlShortenerApiController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @GetMapping
    public ResponseEntity notFound(){
        return new ResponseEntity("Not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity getShortUrlById(@PathVariable String id){
        try{
            long idLong = Long.parseLong(id);
            return urlShortenerService.getShortUrlById(idLong)
                    .map(
                        url -> ResponseEntity
                                .status(HttpStatus.SEE_OTHER)
                                .header(HttpHeaders.LOCATION, url.getOriginal_url())
                                .build()
                    )
                    .orElseGet(
                            () -> new ResponseEntity(
                                    new UrlByIdNotFound(),
                                    HttpStatus.NOT_FOUND
                            )
                    );
        }catch(NumberFormatException e){
            return ResponseEntity
                    .badRequest()
                    .body(new WrongFormat());
        }
    }

    @PostMapping("/new")
    public ResponseEntity createNewShortUrl(@RequestBody @Valid NewUrlRequest newUrlRequest, BindingResult result)
    {
        if(result.hasErrors()){
            return ResponseEntity
                    .badRequest()
                    .body(
                            new MalFormedRequestContent()
                    );
        }else{
            return urlShortenerService.createShortUrl(newUrlRequest.getUrl())
                    .map(
                            url -> new ResponseEntity(url, HttpStatus.CREATED)
                    )
                    .orElseGet(
                            () -> new ResponseEntity(new InvalidUrl(), HttpStatus.NOT_FOUND)
                    );
        }

    }
}
