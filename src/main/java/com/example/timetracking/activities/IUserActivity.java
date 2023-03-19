package com.example.timetracking.activities;

import java.time.LocalDateTime;

public interface IUserActivity {
    boolean isActive(LocalDateTime dateTime);
}
