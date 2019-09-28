package com.flprojects.urlshortener.domain.errors;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InvalidUrlTest {

    InvalidUrl invalidUrl;

    @Before
    public void setUp(){
        invalidUrl = new InvalidUrl();
    }

    @Test
    public void test_getERROR() {
        String expected = "invalid URL";
        assertEquals(expected, invalidUrl.getError());
    }
}
