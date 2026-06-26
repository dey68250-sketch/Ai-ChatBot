package com.ai_ChatBot.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateChatResponse {

    private Long id;
    private String title;
}
