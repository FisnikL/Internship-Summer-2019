package com.flprojects.urlshortener.domain.errors;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UrlByIdNotFoundTest {

    UrlByIdNotFound urlByIdNotFound;

    @Before
    public void setUp() throws Exception {
        urlByIdNotFound = new UrlByIdNotFound();
    }

    @Test
    public void test_getERROR() {
        String expected = "No short url found for given input";
        assertEquals(expected, urlByIdNotFound.getERROR());
    }
}
