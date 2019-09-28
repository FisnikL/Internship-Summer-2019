package com.flprojects.timestamp.domain;

import org.junit.Test;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

public class ValidTimestampTest{

    // Constants
    private final ZoneOffset ZONE_OFFSET = ZoneOffset.UTC;
    private final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.RFC_1123_DATE_TIME;

    // Expected
    private final long expectedUnix = 1450137600L;
    private final Instant expectedInstant = Instant.ofEpochMilli(expectedUnix);

    // Actual timestamp
    private ValidTimestamp actualTimestamp = new ValidTimestamp(expectedUnix, expectedInstant);

    @Test
    public void test_getUnix() {
        assertEquals(expectedUnix, actualTimestamp.getUnix());
    }

    @Test
    public void test_getUtc() {
        String expectedUtc = expectedInstant.atOffset(ZONE_OFFSET).format(DATE_TIME_FORMAT);
        assertEquals(expectedUtc, actualTimestamp.getUtc());
    }
}
