package com.example.timetracking.activities;

import com.example.timetracking.util.Randomizer;
import com.example.timetracking.util.SystemInfoReader;
import com.example.timetracking.util.TimeManager;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@Order(3)
@RequiredArgsConstructor
public class GameActivity implements IUserActivity {
    private final static String PROCESS_NAME = "Skype";
    private final TimeManager timeManager;
    @Override
    public boolean isActive(LocalDateTime dateTime) {
        List<String> list = null;
        try {
            String command = String.format("powershell.exe (Get-Process -Name %s).StartTime.GetDateTimeFormats()[53]", PROCESS_NAME);
            list = new SystemInfoReader().executePowerShellCommand(command);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yy HH:mm");
        LocalDateTime processStartDateTime = LocalDateTime.parse(list.get(0), dateTimeFormatter);

        return timeManager.isWithinPreviousHour(processStartDateTime);
    }
}
