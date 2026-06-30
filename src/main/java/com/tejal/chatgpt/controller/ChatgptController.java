package com.tejal.chatgpt.controller;

import com.tejal.chatgpt.dto.PromptRequestDto;
import com.tejal.chatgpt.service.ChatgptService;

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

  @PostMapping
  public String chat(@RequestBody PromptRequestDto promptRequest) {
    return gptService.getChatgptResponse(promptRequest);
  }

}
