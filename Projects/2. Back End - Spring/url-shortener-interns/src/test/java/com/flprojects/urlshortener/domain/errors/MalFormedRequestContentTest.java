package com.flprojects.urlshortener.domain.errors;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MalFormedRequestContentTest {

    MalFormedRequestContent malFormedRequestContent;

    @Before
    public void setUp() throws Exception {
        malFormedRequestContent = new MalFormedRequestContent();
    }

    @Test
    public void test_getERROR() {
        String expected = "Request should be JSON format with one property 'url'";
        assertEquals(expected, malFormedRequestContent.getERROR());
    }
}
