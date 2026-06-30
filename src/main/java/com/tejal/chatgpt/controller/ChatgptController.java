package com.tejal.chatgpt.controller;

import com.tejal.chatgpt.dto.PromptRequestDto;
import com.tejal.chatgpt.service.ChatgptService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatgptController {

    private final ChatgptService gptService;

    public ChatgptController(ChatgptService gptService) {
        this.gptService = gptService;
    }

    /**
     * Welcome Endpoint
     * URL : GET /api/chat
     */
    @GetMapping
    public String welcome() {

        return """
                ==========================================
                   🤖 AI Teacher ChatBot API
                ==========================================

                Welcome!

                This API allows you to communicate with the AI Teacher.

                Available Endpoints:

                GET  /api/chat
                    → Displays API information

                GET  /api/chat/health
                    → Checks whether the server is running

                GET  /api/chat/example
                    → Shows an example request

                POST /api/chat
                    → Ask any question to the AI

                Example JSON:

                {
                    "prompt": "Explain Java OOP concepts"
                }

                ==========================================
                """;
    }

    /**
     * Health Check Endpoint
     * URL : GET /api/chat/health
     */
    @GetMapping("/health")
    public String health() {
        return "✅ AI Teacher API is running successfully.";
    }

    /**
     * Example Endpoint
     * URL : GET /api/chat/example
     */
    @GetMapping("/example")
    public String example() {

        return """
                Example POST Request

                URL:
                POST /api/chat

                Headers:
                Content-Type: application/json

                Body:

                {
                    "prompt":"Explain Artificial Intelligence"
                }
                """;
    }

    /**
     * Main Chat Endpoint
     * URL : POST /api/chat
     */
    @PostMapping
    public String chat(@RequestBody PromptRequestDto promptRequest) {

        if (promptRequest == null ||
                promptRequest.prompt() == null ||
                promptRequest.prompt().trim().isEmpty()) {

            return "❌ Please enter a valid question.";
        }

        return gptService.getChatgptResponse(promptRequest);
    }

}
