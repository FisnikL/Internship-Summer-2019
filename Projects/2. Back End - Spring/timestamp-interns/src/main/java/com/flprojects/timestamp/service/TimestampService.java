package com.flprojects.timestamp.service;

import com.flprojects.timestamp.domain.InvalidTimestamp;
import com.flprojects.timestamp.domain.Timestamp;
import com.flprojects.timestamp.domain.ValidTimestamp;
import org.springframework.stereotype.Service;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeParseException;

@Service
public class TimestampService {

    public Timestamp getCurrentTimestamp(Instant now){
        return new ValidTimestamp(now.toEpochMilli(), now);
    }

    public Timestamp getParsedTimestamp(String timestamp) {
        if (isNumber(timestamp)) {
            try{
                long timestampLong = Long.parseLong(timestamp);         // throws NumberFormatException
                Instant instant = Instant.ofEpochMilli(timestampLong);  // throws DateTimeException
                return new ValidTimestamp(timestampLong, instant);
            }catch(NumberFormatException | DateTimeException e){
                return new InvalidTimestamp();
            }
        } else {
            try{
                LocalDate localDate = LocalDate.parse(timestamp);       // throws DateTimeParseException
                Instant instant = localDate.atStartOfDay().toInstant(ZoneOffset.UTC);
                long epochMilli = instant.toEpochMilli();
                return new ValidTimestamp(epochMilli, instant);
            }catch(DateTimeParseException e){
                return new InvalidTimestamp();
            }
        }
    }

    public boolean isNumber(String value){
        for(int i = 0; i < value.length(); ++i){
            if(!Character.isDigit(value.charAt(i)))
                return false;
        }
        return true;
    }
}
