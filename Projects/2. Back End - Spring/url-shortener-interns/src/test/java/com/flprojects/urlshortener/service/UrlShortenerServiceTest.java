package com.flprojects.urlshortener.service;

import com.flprojects.urlshortener.domain.Url;
import com.flprojects.urlshortener.service.mock_shortUrl.MockShortUrl;
import com.flprojects.urlshortener.service.mock_repository.MockRepository;
import org.junit.Test;

import static org.junit.Assert.*;

public class UrlShortenerServiceTest {

    final UrlShortenerService urlShortenerService = new UrlShortenerService(
            new MockRepository(),
            new MockShortUrl()
    );

    @Test
    public void test_isValidUrl_withValidURL(){
        final String url = "https://www.google.com/";
        final boolean expected = true;
        boolean actual = urlShortenerService.isUrlValid(url);
        assertEquals(expected, actual);
    }

    @Test
    public void test_isValidUrl_withInvalidURL1(){
        final String url = "https://www.gogle.com/";
        final boolean expected = false;
        boolean actual = urlShortenerService.isUrlValid(url);
        assertEquals(expected, actual);
    }

    @Test
    public void test_isValidUrl_withInvalidURL2(){
        final String url = "ht://www.google.com/";
        final boolean expected = false;
        boolean actual = urlShortenerService.isUrlValid(url);
        assertEquals(expected, actual);
    }

    @Test
    public void test_createShortUrl_withValidURL() {
        final String expected = "https://www.google.com/";
        String actual = urlShortenerService
                .createShortUrl(expected)
                .map(url -> url.getOriginal_url())
                .orElseGet(null);

        assertEquals(expected, actual);
    }

    @Test
    public void test_createShortUrl_withInvalidURL() {
        final String url_arg = "https:/ww.goole.com/";

        String actual = urlShortenerService
                .createShortUrl(url_arg)
                .map(url -> url.getOriginal_url())
                .orElse( null);

        assertEquals(null, actual);
    }

    @Test
    public void test_urlObjectCreation() {
        final String url = "https://www.google.com/";
        Url expected = new Url(0L, url);

        Url actual = urlShortenerService
                .createShortUrl(url)
                .orElse(null);

        assertEquals(expected, actual);
    }

    @Test
    public void test_getShortUrlById_whenIdIsPresent() {
        Url expected = new Url(1111L, "https://www.google.com/");

        Url actual = urlShortenerService
                .getShortUrlById(1111L)
                .orElse(null);

        assertEquals(expected, actual);
    }

    @Test
    public void test_getShortUrlById_whenIdIsNotPresent() {
        Url actual = urlShortenerService
                .getShortUrlById(8888L)
                .orElse(null);

        assertEquals(null, actual);
    }
}
