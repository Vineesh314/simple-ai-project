package com.ai.simple.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for AI query response
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AIQueryResponse {
    
    private String response;
    private String model;
    private Long processingTime;
}

