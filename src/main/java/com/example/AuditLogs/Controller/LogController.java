package com.example.AuditLogs.Controller;


import com.example.AuditLogs.DTO.LogRequest;
import com.example.AuditLogs.Model.LogEntity;
import com.example.AuditLogs.Service.LogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/logs")
public class LogController {
    @Autowired
    private LogService service;

    @PostMapping
    public LogEntity create(@Valid @RequestBody LogRequest request){
        return service.createLog(request);
    }
    @GetMapping
    public Page<LogEntity> all(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "5")int size){
        return service.getAllLogs(page, size);

    }
    @GetMapping("/user/{userId}")
    public Page<LogEntity> byUser(@PathVariable String userId,
                                  @RequestParam(defaultValue = "0")int page,
                                  @RequestParam(defaultValue = "5")int size){
        return service.getLogsByUser(userId, page, size);
    }
    @GetMapping("/date")
    public Page<LogEntity> byDate(@RequestParam LocalDateTime start,
                                  @RequestParam LocalDateTime end,
                                  @RequestParam(defaultValue = "0")int page,
                                  @RequestParam(defaultValue = "5")int size){
        return service.getLogsByDate(start, end, page, size);
    }
    @GetMapping("/filter")
    public Page<LogEntity> filter(@RequestParam String userId,
                                  @RequestParam LocalDateTime start,
                                  @RequestParam LocalDateTime end,
                                  @RequestParam(defaultValue = "0")int page,
                                  @RequestParam(defaultValue = "5")int size){
        return service.getLogsByUserAndDate(userId, start, end, page, size);
    }
}
