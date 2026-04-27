package com.example.AuditLogs.Service.impl;

import com.example.AuditLogs.DTO.LogRequest;
import com.example.AuditLogs.Model.LogEntity;
import com.example.AuditLogs.Repository.LogRepository;
import com.example.AuditLogs.Service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDateTime;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository logRepository;

    public LogEntity createLog(LogRequest logRequest){
        LogEntity log=new LogEntity();
        log.setUserId(logRequest.getUserId());
        log.setActionType(logRequest.getActionType());
        log.setModuleName(logRequest.getModuleName());
        log.setTimestamp(LocalDateTime.now());

        return logRepository.save(log);
    }
    public Page<LogEntity> getAllLogs(int page,int size){
        return logRepository.findAll(PageRequest.of(page, size, Sort.by("timestamp").descending()));

    }
    public Page<LogEntity> getLogsByUser(String userId,int page,int size){
        return logRepository.findByUserId(userId,PageRequest.of(page,size));
    }
    public Page<LogEntity> getLogsByDate(LocalDateTime start,LocalDateTime end,int
                                          page,int size){
        return logRepository.findByTimestampBetween(start,end, PageRequest.of(page,size));
    }
    public Page<LogEntity> getLogsByUserAndDate(String userId,LocalDateTime start,LocalDateTime end,int page,int size){
        return logRepository.findByUserIdAndTimestampBetween(userId,start,end,PageRequest.of(page,size));
    }
}