package com.example.timetracking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cat_facts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryFactPriority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "cat_id", referencedColumnName = "id")
    private Category category;

    @Column(name = "cat_priority")
    private int priority;
}
