package com.ai.simple.config;

import com.ai.simple.common.constant.Constants;
import dev.langchain4j.model.ollama.OllamaChatModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;


@Configuration
public class AIModelConfig {

    private static final Logger logger = LoggerFactory.getLogger(AIModelConfig.class);

    @Bean
    public OllamaChatModel llamaModel() {
        logger.info("Initializing Llama Model with URL: {} and model: {}", 
                   Constants.DEFAULT_OLLAMA_BASE_URL, Constants.MODEL_LLAMA);
        logger.info("GPU acceleration: Managed by Ollama server (automatic detection)");

        return OllamaChatModel.builder()
                .baseUrl(Constants.DEFAULT_OLLAMA_BASE_URL)
                .modelName(Constants.MODEL_LLAMA)
                .timeout(Duration.ofSeconds(120))
                .build();
    }

    @Bean
    public OllamaChatModel phiModel() {
        logger.info("Initializing Phi Model with URL: {} and model: {}", 
                   Constants.DEFAULT_OLLAMA_BASE_URL, Constants.MODEL_PHI);
        logger.info("GPU acceleration: Managed by Ollama server (automatic detection)");

        return OllamaChatModel.builder()
                .baseUrl(Constants.DEFAULT_OLLAMA_BASE_URL)
                .modelName(Constants.MODEL_PHI)
                .timeout(Duration.ofSeconds(120))
                .build();
    }

    @Bean
    public OllamaChatModel coderModel() {
        logger.info("Initializing Coder Model with URL: {} and model: {}", 
                   Constants.DEFAULT_OLLAMA_BASE_URL, Constants.MODEL_CODER);
        logger.info("GPU acceleration: Managed by Ollama server (automatic detection)");

        return OllamaChatModel.builder()
                .baseUrl(Constants.DEFAULT_OLLAMA_BASE_URL)
                .modelName(Constants.MODEL_CODER)
                .timeout(Duration.ofSeconds(120))
                .build();
    }
}
