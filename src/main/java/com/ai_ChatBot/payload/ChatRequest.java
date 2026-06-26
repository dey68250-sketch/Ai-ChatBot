package com.ai_ChatBot.payload;

import lombok.Data;

@Data
public class ChatRequest {

    private Long chatId; // null = create new chat
    private String message;
}