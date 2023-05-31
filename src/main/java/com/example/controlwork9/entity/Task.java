package com.example.controlwork9.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    @Size(max = 20)
    private String title;

    @Column(name = "creation_date")
    @PastOrPresent
    private LocalDate creationDate;

    @ManyToOne
    @JoinColumn(name = "developer_id")
    private User developer;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<WorkLog> workLogs = new ArrayList<>();

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<Attachment> attachments = new ArrayList<>();
}
