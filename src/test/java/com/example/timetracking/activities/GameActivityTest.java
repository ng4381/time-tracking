package com.example.timetracking.activities;

import com.example.timetracking.util.TimeManager;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.LocalDateTime;

class GameActivityTest {
    @Test
    public void test() {
        IUserActivity gameActivity = new GameActivity(new TimeManager());
        System.out.println("isActive " + gameActivity.isActive(LocalDateTime.now(Clock.systemDefaultZone())));
    }
}