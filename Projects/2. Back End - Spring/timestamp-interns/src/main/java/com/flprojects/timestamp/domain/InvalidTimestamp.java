package com.flprojects.timestamp.domain;

public class InvalidTimestamp implements Timestamp
{
    private final String ERROR = "Invalid Date";;

    public InvalidTimestamp() {
    }

    public String getError() {
        return ERROR;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvalidTimestamp)) return false;
        InvalidTimestamp that = (InvalidTimestamp) o;
        return ERROR.equals(that.ERROR);
    }
}
