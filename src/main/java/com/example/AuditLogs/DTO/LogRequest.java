package com.example.AuditLogs.DTO;


import com.fasterxml.jackson.core.SerializableString;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LogRequest {
    @NotBlank
    private String userId;
    @NotBlank
    private String actionType;
    @NotBlank
    private String moduleName;
}
