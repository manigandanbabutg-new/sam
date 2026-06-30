package com.tejal.chatgpt.dto;

import java.util.List;

public record ChatgptResponseDto(List<Choice> choices) {
  public record Choice(String model, Message message) {
    public record Message(String role, String content) {
    }
  }
}