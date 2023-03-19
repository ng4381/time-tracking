package com.example.timetracking;

import com.example.timetracking.activities.IUserActivity;
import com.example.timetracking.repository.CategoryRepository;
import com.example.timetracking.service.UserActivityService;
import com.example.timetracking.service.UserDateTimeActivityService;
import com.sun.jna.platform.win32.Advapi32Util;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MyRunner implements CommandLineRunner {

    private final List<IUserActivity> userActivities;

    private final UserDateTimeActivityService userDateTimeActivityService;

    private final UserActivityService userActivityService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("[NIKITA] Command line runner");

        userActivityService.process();


        /*
        userActivities.forEach(iUserActivity -> System.out.println(iUserActivity.getClass().getName()));
        for (IUserActivity userActivity : userActivities) {
            LocalDateTime dateTime = LocalDateTime.now().minusHours(1);
            dateTime = LocalDate.EPOCH.atTime(dateTime.getHour(),0);

            if (userActivity.isActive(dateTime)) {
                // record to DB
                break;
            }
        }
         */
    }
}
