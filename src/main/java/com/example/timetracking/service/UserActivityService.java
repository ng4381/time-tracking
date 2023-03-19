package com.example.timetracking.service;

import com.example.timetracking.activities.IUserActivity;
import com.example.timetracking.entity.UserDateTimeActivity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class UserActivityService {
    private final List<IUserActivity> userActivities;
    private final UserDateTimeActivityService userDateTimeActivityService;
    private final CategoryService categoryService;

    private LocalDateTime getStartOfPreviousHour() {
        LocalDateTime dateTime = LocalDateTime.now(Clock.systemDefaultZone()).minusHours(1);
        return LocalDate.now().atTime(dateTime.getHour(),0);
    }

    public void process() {
        for (IUserActivity userActivity : userActivities) {
            LocalDateTime dateTime = getStartOfPreviousHour();

            if (userActivity.isActive(dateTime)) {
                UserDateTimeActivity userDateTimeActivity = UserDateTimeActivity.builder()
                        .dayName(dateTime.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH))
                        .category(categoryService.getCategory(2L))
                        .dateTime(dateTime).build();

                userDateTimeActivityService.saveUserDateTimeActivity(userDateTimeActivity);
                userDateTimeActivityService.cutRecords();
                return;
            }
        }
    }
}
