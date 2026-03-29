package com.ai.simple.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Request DTO for AI Router queries
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AIQueryRequest {
    
    @JsonProperty("question")
    private String question;
}

