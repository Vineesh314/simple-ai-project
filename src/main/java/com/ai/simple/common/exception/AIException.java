package com.ai.simple.common.exception;

/**
 * Base exception for AI operations
 */
public class AIException extends RuntimeException {
    
    private final String errorCode;
    private final String details;

    public AIException(String message, String errorCode, String details) {
        super(message);
        this.errorCode = errorCode;
        this.details = details;
    }

    public AIException(String message, String errorCode, String details, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
        this.details = details;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getDetails() {
        return details;
    }
}

