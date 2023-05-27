package com.example.controlwork9.entity;

import lombok.Data;
import javax.persistence.*;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "attachments")
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "filename")
    @Size(max = 50)
    private String filename;

    @Column(name = "filepath")
    @Size(max = 100)
    private String filepath;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
}