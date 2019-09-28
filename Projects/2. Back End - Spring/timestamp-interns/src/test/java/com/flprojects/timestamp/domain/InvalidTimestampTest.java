package com.flprojects.timestamp.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class InvalidTimestampTest {

    @Test
    public void test_getError() {
        final String expected = "Invalid Date";
        InvalidTimestamp actual = new InvalidTimestamp();

        assertEquals(expected, actual.getError());
    }
}
