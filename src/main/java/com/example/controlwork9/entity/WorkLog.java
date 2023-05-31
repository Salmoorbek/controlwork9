package com.example.controlwork9.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "worklogs")
public class WorkLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @Column(name = "time_spent")
    @Size(max = 6)
    private String timeSpent;

    @Column(name = "description")
    @Size(max = 50)
    private String description;
}