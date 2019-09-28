package com.flprojects.timestamp.domain;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class ValidTimestamp implements Timestamp{
    private final ZoneOffset ZONE_OFFSET = ZoneOffset.UTC;
    private final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.RFC_1123_DATE_TIME;

    private long unix;
    private String utc;

    public ValidTimestamp() {
    }

    public ValidTimestamp(long unix, Instant instant) {
        this.unix = unix;
        this.utc = instant.atOffset(ZONE_OFFSET).format(DATE_TIME_FORMATTER);
    }

    public long getUnix() {
        return unix;
    }

    public String getUtc() {
        return utc;
    }

    public void setUnix(long unix) {
        this.unix = unix;
    }

    public void setUtc(String utc) {
        this.utc = utc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ValidTimestamp)) return false;
        ValidTimestamp that = (ValidTimestamp) o;
        return unix == that.unix &&
                utc.equals(that.utc);
    }
}
