package com.example.timetracking.activities;

import com.example.timetracking.util.Randomizer;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Order(1)
public class StudyActivity implements IUserActivity{
    @Override
    public boolean isActive(LocalDateTime dateTime) {
        // TODO no implementation
        return Randomizer.getRandomBoolean();
    }
}
