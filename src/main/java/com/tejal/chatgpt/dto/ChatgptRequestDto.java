package com.tejal.chatgpt.dto;

import java.util.List;

public record ChatgptRequestDto(String model, List<Message> messages) {

  public static record Message(String role, String content) {

  }
}
