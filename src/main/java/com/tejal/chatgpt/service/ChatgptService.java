package com.tejal.chatgpt.service;

import com.tejal.chatgpt.dto.ChatgptRequestDto;
import com.tejal.chatgpt.dto.ChatgptResponseDto;
import com.tejal.chatgpt.dto.PromptRequestDto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatgptService {

  private final RestClient restClient;

  // @Autowired
  public ChatgptService(RestClient restClient) {
    this.restClient = restClient;
  }

  @Value("${openapi.api.key}")
  private String apiKey ;

  @Value("${openapi.api.model}")
  private String apiModel;

  public String getChatgptResponse(PromptRequestDto promptRequest) {

    ChatgptRequestDto chatgptRequest =  new ChatgptRequestDto(
              apiModel,
              List.of(new ChatgptRequestDto.Message("user", promptRequest.prompt()))
            );

    ChatgptResponseDto chatgptResponse = restClient.post()
            .header("Authorization", "Bearer "+apiKey)
            .header("Content-Type", "application/json")
            .body(chatgptRequest).retrieve()
            .body(ChatgptResponseDto.class);

    return chatgptResponse.choices().get(0).message().content();
  }
}
