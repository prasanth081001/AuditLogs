package com.example.AuditLogs.Repository;


import com.example.AuditLogs.Model.LogEntity;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface LogRepository extends JpaRepository<LogEntity,Long> {

    Page<LogEntity> findByUserId(String userId, Pageable pageable);

    Page<LogEntity> findByTimestampBetween(LocalDateTime start,LocalDateTime end,Pageable pageable);

    Page<LogEntity> findByUserIdAndTimestampBetween(String userId, LocalDateTime start, LocalDateTime end,Pageable pageable);
}
