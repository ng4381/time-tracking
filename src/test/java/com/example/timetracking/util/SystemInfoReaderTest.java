package com.example.timetracking.util;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

class SystemInfoReaderTest {
    @Test
    public void test2() throws Exception {
        List<String> list = new SystemInfoReader().executePowerShellCommand("powershell.exe (Get-Process -Name Skype).StartTime.GetDateTimeFormats()[53]");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yy HH:mm");

        LocalDateTime localDate = LocalDateTime.parse(list.get(0), dateTimeFormatter);

        System.out.println(localDate);
    }
}