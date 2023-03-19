package com.example.timetracking.service;

import com.example.timetracking.entity.UserDateTimeActivity;
import com.example.timetracking.repository.UserDateTimeActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDateTimeActivityService {

    private static final int RECORDS_MAX_NUMBER = 3;
    private final UserDateTimeActivityRepository userDateTimeActivityRepository;

    public void saveUserDateTimeActivity(UserDateTimeActivity userDateTimeActivity) {
        userDateTimeActivityRepository.save(userDateTimeActivity);
    }
    public void cutRecords() {
        Page<UserDateTimeActivity> userDateTimeActivities = userDateTimeActivityRepository.findAll(getPageRequest(0));
        List<UserDateTimeActivity> listToDelete = new ArrayList<>();

        for (int i = 1; i < userDateTimeActivities.getTotalPages(); i++) {
            Page<UserDateTimeActivity> list = userDateTimeActivityRepository.findAll(getPageRequest(i));
            listToDelete.addAll(list.toList());
        }

        listToDelete.forEach(userDateTimeActivity -> System.out.println("id = " + userDateTimeActivity.getId()  + "  datetime = " + userDateTimeActivity.getDateTime()));
        userDateTimeActivityRepository.deleteAll(listToDelete);
    }

    private PageRequest getPageRequest(int page) {
        return PageRequest.of(page, RECORDS_MAX_NUMBER, Sort.by(Sort.Direction.DESC, "dateTime"));
    }
}
