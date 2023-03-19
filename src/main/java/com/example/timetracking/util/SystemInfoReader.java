package com.example.timetracking.util;

import com.sun.jna.platform.win32.Advapi32Util;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class SystemInfoReader {

    /**
     * @param command
     * Examples of commands
     *         powershell.exe Get-EventLog –LogName ‘Application’ -After 3/1/2023 | Format-Table EntryType, TimeWritten, Source, EventID, Category, Message
     *         powershell.exe Get-EventLog –LogName ‘Application’ -After 3/1/2023
     *         powershell.exe (Get-Process -Name Skype).StartTime
     *
     *         (Get-Process -Name Skype).StartTime.GetDateTimeFormats()[0]
     *
     * @throws Exception
     */

    public List<String> executePowerShellCommand(String command) throws Exception {
        List<String> result = new ArrayList<>();
        Process powerShellProcess = Runtime.getRuntime().exec(command);

        powerShellProcess.getOutputStream().close();
        String line;
        System.out.println("Standard Output:");
        BufferedReader stdout = new BufferedReader(new InputStreamReader(
                powerShellProcess.getInputStream()));
        while ((line = stdout.readLine()) != null) {
            System.out.println(line);
            result.add(line);
        }
        stdout.close();
        System.out.println("Standard Error:");
        BufferedReader stderr = new BufferedReader(new InputStreamReader(
                powerShellProcess.getErrorStream()));
        while ((line = stderr.readLine()) != null) {
            System.out.println(line);

        }
        stderr.close();
        System.out.println("Done");
        return result;
    }

    private void EventLogJNA() {
        Advapi32Util.EventLogIterator iter = new Advapi32Util.EventLogIterator("Application");
        while (iter.hasNext()) {
            Advapi32Util.EventLogRecord record = iter.next();
            System.out.println(record.getRecordNumber()
                    + ": Event ID: " + record.getEventId()
                    + ", Event Type: " + record.getType()
                    + ", Event Source: " + record.getSource());
        }
    }
}
