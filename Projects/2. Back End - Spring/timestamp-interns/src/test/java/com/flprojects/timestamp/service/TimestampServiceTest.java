package com.flprojects.timestamp.service;

import com.flprojects.timestamp.domain.InvalidTimestamp;
import com.flprojects.timestamp.domain.ValidTimestamp;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

public class TimestampServiceTest{
    TimestampService timestampService = new TimestampService();

    @Test
    public void test_isNumber1() {
        final String number = "123432412321";
        assertTrue(timestampService.isNumber(number));
    }
    @Test
    public void test_isNumber2(){
        final String notNumber = "123234324f1231a";
        assertFalse(timestampService.isNumber(notNumber));
    }



    @Test
    public void test_getCurrentTimestamp1() {

        Instant now = Instant.ofEpochMilli(1564409564299L);
        ValidTimestamp timestamp = (ValidTimestamp) timestampService.getCurrentTimestamp(now);

        assertEquals(1564409564299L, timestamp.getUnix());
        assertEquals("Mon, 29 Jul 2019 14:12:44 GMT", timestamp.getUtc());
    }

    @Test
    public void test_getParsedTimestamp2() {
        final String timestamp = "1231231233112";

        long unix = 1231231233112L;
        String utc = "Tue, 6 Jan 2009 08:40:33 GMT";
        ValidTimestamp expected = new ValidTimestamp();
        expected.setUnix(unix);
        expected.setUtc(utc);

        ValidTimestamp actual = (ValidTimestamp) timestampService.getParsedTimestamp(timestamp);
        assertEquals(expected, actual);
    }


    @Test
    public void test_getParsedTimestamp3() {
        final String timestamp = "2019-07-28";

        long unix = 1564272000000L;
        String utc = "Sun, 28 Jul 2019 00:00:00 GMT";
        ValidTimestamp expected = new ValidTimestamp();
        expected.setUnix(unix);
        expected.setUtc(utc);

        ValidTimestamp actual = (ValidTimestamp) timestampService.getParsedTimestamp(timestamp);
        assertEquals(expected, actual);
    }


    @Test
    public  void test_getParsedTimestamp4(){
        final String timestamp = "12312312ads";

        InvalidTimestamp expected = new InvalidTimestamp();
        InvalidTimestamp actual = (InvalidTimestamp) timestampService.getParsedTimestamp(timestamp);

        assertEquals(expected, actual);
    }

    @Test
    public  void test_getParsedTimestamp5(){
        final String timestamp = "56424799989712121333"; // NumberFormatException - value is bigger than Long.MAX_VALUE

        InvalidTimestamp expected = new InvalidTimestamp();
        InvalidTimestamp actual = (InvalidTimestamp) timestampService.getParsedTimestamp(timestamp);

        assertEquals(expected, actual);
    }

    @Test
    public  void test_getParsedTimestamp6(){
        final String timestamp = "564247999897122";     // DateTimeException - the year is more than 4 digits

        InvalidTimestamp expected = new InvalidTimestamp();
        InvalidTimestamp actual = (InvalidTimestamp) timestampService.getParsedTimestamp(timestamp);

        assertEquals(expected, actual);
    }


    @Test
    public  void test_getParsedTimestamp7(){
        final String timestamp = "2016-31-10";     // DateTimeParseException - date format should be yyyy-mm-dd

        InvalidTimestamp expected = new InvalidTimestamp();
        InvalidTimestamp actual = (InvalidTimestamp) timestampService.getParsedTimestamp(timestamp);

        assertEquals(expected, actual);
    }

    @Test
    public void test_getParsedTimestamp8(){
        final String timestamp = "-12343242342";

        InvalidTimestamp expected = new InvalidTimestamp();
        InvalidTimestamp actual = (InvalidTimestamp) timestampService.getParsedTimestamp(timestamp);

        assertEquals(expected, actual);
    }

    @Test
    public void test_getParsedTimestamp9() {
        final String timestamp = "0";

        long unix = 0L;
        String utc = "Thu, 1 Jan 1970 00:00:00 GMT";
        ValidTimestamp expected = new ValidTimestamp();
        expected.setUnix(unix);
        expected.setUtc(utc);

        ValidTimestamp actual = (ValidTimestamp) timestampService.getParsedTimestamp(timestamp);
        assertEquals(expected, actual);
    }
}
