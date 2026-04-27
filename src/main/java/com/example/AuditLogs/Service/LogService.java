package com.example.AuditLogs.Service;

import com.example.AuditLogs.DTO.LogRequest;
import com.example.AuditLogs.Model.LogEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface LogService {

    LogEntity createLog(LogRequest request);

    Page<LogEntity> getAllLogs(int page,int size);
    Page<LogEntity> getLogsByUser(String userId,int page,int size);
    Page<LogEntity> getLogsByDate(LocalDateTime start,LocalDateTime end,int page,int size);

    Page<LogEntity> getLogsByUserAndDate(String userId, LocalDateTime start,LocalDateTime end,int page,int size);
}
