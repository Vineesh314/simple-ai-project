package com.ai.simple.common.exception;

/**
 * Exception thrown when LLM model inference fails
 */
public class ModelInferenceException extends AIException {
    
    public ModelInferenceException(String message, Throwable cause) {
        super(message, "MODEL_INFERENCE_ERROR", "Failed to generate response from LLM", cause);
    }
}

