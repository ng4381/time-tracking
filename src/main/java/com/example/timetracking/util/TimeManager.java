package com.example.timetracking.util;

import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class TimeManager {
    public LocalDateTime getStartOfPreviousHour() {
        LocalDateTime dateTime = LocalDateTime.now(Clock.systemDefaultZone()).minusHours(1);
        return LocalDate.now().atTime(dateTime.getHour(),0);
    }

    public boolean isWithinPreviousHour(LocalDateTime processStartDateTime) {
        LocalDateTime dateTime = getStartOfPreviousHour();
        LocalDateTime start = dateTime;
        LocalDateTime end = dateTime.plusSeconds(60*60);
        System.out.println("processStartDateTime = " + processStartDateTime);
        System.out.println("start = " + start);
        System.out.println("end = " + end);
        return (processStartDateTime.isAfter(start.minusSeconds(1)) && processStartDateTime.isBefore(end));
    }

}
