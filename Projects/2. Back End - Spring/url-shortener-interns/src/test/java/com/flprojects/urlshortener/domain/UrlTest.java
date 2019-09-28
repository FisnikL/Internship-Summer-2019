package com.flprojects.urlshortener.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UrlTest {

    Url url;
    final Long expectedShortURL = 12345L;
    final String expectedOriginalURL = "https://example.org";

    @Before
    public void setUp(){
        url = new Url(expectedShortURL, expectedOriginalURL);
    }

    @Test
    public void test_getOriginal_url() {
        assertEquals(expectedShortURL, url.getShort_url_id());
    }

    @Test
    public void test_getShort_url_id() {
        assertEquals(expectedOriginalURL, url.getOriginal_url());
    }
}
