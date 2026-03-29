package com.ai.simple.controller;

import com.ai.simple.common.dto.AIQueryRequest;
import com.ai.simple.common.dto.AIQueryResponse;
import com.ai.simple.service.AIRouterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AI Router API - Intelligent Model Selection
 * Routes queries to the most appropriate AI model (Llama, Phi, Coder)
 */
@RestController
@RequestMapping("/api/ai")
@Tag(name = "AI APIs", description = "APIs for AI transactions")
public class AIRouterController {

    private static final Logger logger = LoggerFactory.getLogger(AIRouterController.class);

    private final AIRouterService service;

    public AIRouterController(AIRouterService service) {
        this.service = service;
    }

    @PostMapping("/query")
    @Operation(
            summary = "POST API for AI query",
            description = "Accepts a question and routes it to the appropriate AI model (Llama, Phi, Coder) based on the content of the question. Returns the generated response along with model information and processing time."
    )
    public ResponseEntity<AIQueryResponse> queryPost(@RequestBody AIQueryRequest request) {
        if (request == null || request.getQuestion() == null || request.getQuestion().trim().isEmpty()) {
            logger.error("Invalid request: question is required");
            throw new IllegalArgumentException("Question is required");
        }

        String question = request.getQuestion();
        logger.info("AI query (POST): {}", question);

        long startTime = System.currentTimeMillis();
        String response = service.ask(question);
        long processingTime = System.currentTimeMillis() - startTime;

        AIQueryResponse queryResponse = new AIQueryResponse(response, "AI Router", processingTime);
        return ResponseEntity.ok(queryResponse);
    }
}


