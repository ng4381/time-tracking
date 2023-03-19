package com.example.timetracking.repository;

import com.example.timetracking.entity.UserDateTimeActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDateTimeActivityRepository extends JpaRepository<UserDateTimeActivity, Long> {
}
