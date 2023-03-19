package com.example.timetracking.repository;

import com.example.timetracking.entity.CategoryFactPriority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryFactRepository extends JpaRepository<CategoryFactPriority, Long> {
}
