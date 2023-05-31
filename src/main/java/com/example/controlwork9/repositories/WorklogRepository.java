package com.example.controlwork9.repositories;

import com.example.controlwork9.entity.Task;
import com.example.controlwork9.entity.WorkLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorklogRepository extends JpaRepository<WorkLog, Long> {
    List<WorkLog> findByTaskId(Long taskId);
}
