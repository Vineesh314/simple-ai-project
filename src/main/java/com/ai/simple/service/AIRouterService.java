package com.ai.simple.service;

import com.ai.simple.common.exception.ModelInferenceException;
import dev.langchain4j.model.ollama.OllamaChatModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class AIRouterService {

    private static final Logger logger = LoggerFactory.getLogger(AIRouterService.class);

    private final OllamaChatModel llamaModel;
    private final OllamaChatModel phiModel;
    private final OllamaChatModel coderModel;

    public AIRouterService(OllamaChatModel llamaModel,
                           OllamaChatModel phiModel,
                           OllamaChatModel coderModel) {

        this.llamaModel = llamaModel;
        this.phiModel = phiModel;
        this.coderModel = coderModel;
    }

    /**
     * Route question to the most appropriate model
     * 
     * @param question The question to process
     * @return The generated response with model information
     * @throws ModelInferenceException if model inference fails
     */
    public String ask(String question) {

        if (question == null || question.trim().isEmpty()) {
            logger.warn("Empty question provided to router");
            throw new IllegalArgumentException("Question cannot be empty");
        }

        try {
            if (isCodingQuestion(question)) {
                logger.info("Routing to Coder Model for question: {}", question);
                String response = coderModel.chat(question);
                logger.debug("Coder model responded successfully");
                return "CoderModel: " + response;
            }

            if (isMathQuestion(question)) {
                logger.info("Routing to Phi Model for question: {}", question);
                String response = phiModel.chat(question);
                logger.debug("Phi model responded successfully");
                return "PhiModel: " + response;
            }

            logger.info("Routing to Llama Model for question: {}", question);
            String response = llamaModel.chat(question);
            logger.debug("Llama model responded successfully");
            return "LlamaModel: " + response;

        } catch (Exception e) {
            logger.error("Model inference failed for question: {}", question, e);
            throw new ModelInferenceException("Failed to generate response", e);
        }
    }

    /**
     * Detect if the question is programming-related or technology/architecture-related
     */
    private boolean isCodingQuestion(String q) {
        String lower = q.toLowerCase();
        return lower.contains("java")
                || lower.contains("code")
                || lower.contains("algorithm")
                || lower.contains("leetcode")
                || lower.contains("python")
                || lower.contains("function")
                || lower.contains("debug")
                || lower.contains("kafka")           // Messaging & streaming
                || lower.contains("database")        // Data storage
                || lower.contains("sql")             // SQL queries
                || lower.contains("nosql")           // NoSQL databases
                || lower.contains("mongodb")         // Specific DB
                || lower.contains("mysql")           // Specific DB
                || lower.contains("postgresql")      // Specific DB
                || lower.contains("redis")           // Cache/store
                || lower.contains("api")             // API design
                || lower.contains("rest")            // REST APIs
                || lower.contains("graphql")         // GraphQL
                || lower.contains("microservice")    // Architecture
                || lower.contains("docker")          // Containerization
                || lower.contains("kubernetes")      // Orchestration
                || lower.contains("k8s")             // K8s abbreviation
                || lower.contains("spring")          // Spring framework
                || lower.contains("hibernate")       // ORM
                || lower.contains("git")             // Version control
                || lower.contains("deployment")      // DevOps
                || lower.contains("ci/cd")           // Pipeline
                || lower.contains("jenkins")         // CI/CD tool
                || lower.contains("aws")             // Cloud
                || lower.contains("azure")           // Cloud
                || lower.contains("gcp")             // Cloud
                || lower.contains("load balance")    // Infrastructure
                || lower.contains("cache")           // Performance
                || lower.contains("orm")             // Database
                || lower.contains("json")            // Data format
                || lower.contains("xml")             // Data format
                || lower.contains("http")            // Protocol
                || lower.contains("tcp")             // Protocol
                || lower.contains("socket")          // Network
                || lower.contains("async")           // Concurrency
                || lower.contains("thread")          // Concurrency
                || lower.contains("concurrency")     // Concurrency
                || lower.contains("lambda")          // Functional programming
                || lower.contains("stream")          // Stream processing
                || lower.contains("hadoop")          // Big data
                || lower.contains("spark")           // Big data
                || lower.contains("rabbitmq")        // Message queue
                || lower.contains("queue")           // Messaging
                || lower.contains("index")           // Database optimization
                || lower.contains("schema")          // Database design
                || lower.contains("migration")       // Database
                || lower.contains("logging")         // Observability
                || lower.contains("monitoring")      // Observability
                || lower.contains("authentication")  // Security
                || lower.contains("authorization")   // Security
                || lower.contains("encryption")      // Security
                || lower.contains("jwt")             // Token
                || lower.contains("oauth")           // Security
                || lower.contains("design pattern")  // Software design
                || lower.contains("solid")           // Principles
                || lower.contains("refactor")        // Code quality
                || lower.contains("test")            // Testing
                || lower.contains("junit")           // Testing framework
                || lower.contains("mock")            // Testing
                || lower.contains("compile")         // Build
                || lower.contains("build")           // Build
                || lower.contains("maven")           // Build tool
                || lower.contains("gradle")          // Build tool
                || lower.contains("npm")             // Package manager
                || lower.contains("interface")       // Programming
                || lower.contains("class")           // Programming
                || lower.contains("object")          // OOP
                || lower.contains("inheritance")     // OOP
                || lower.contains("polymorphism");   // OOP
    }

    /**
     * Detect if the question is math-related
     */
    private boolean isMathQuestion(String q) {
        return q.matches(".*\\d+.*[+\\-*/].*")
                || q.toLowerCase().contains("calculate")
                || q.toLowerCase().contains("math")
                || q.toLowerCase().contains("formula");
    }
}
