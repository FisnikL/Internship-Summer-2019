package com.flprojects.timestamp.controller;
import com.flprojects.timestamp.domain.Timestamp;
import com.flprojects.timestamp.service.TimestampService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;

@RestController
@RequestMapping(path="/api/timestamp")
public class TimestampController {
    private final TimestampService timestampService;

    public TimestampController(TimestampService timestampService) {
        this.timestampService = timestampService;
    }

    @GetMapping
    public ResponseEntity<Timestamp> getCurrentTimeStamp(){
        return ResponseEntity.ok(timestampService.getCurrentTimestamp(Instant.now()));
    }

    @GetMapping("/{timestamp}")
    public ResponseEntity<Timestamp> getTimestamp(@PathVariable String timestamp){
        return ResponseEntity.ok(timestampService.getParsedTimestamp(timestamp));
    }
}
