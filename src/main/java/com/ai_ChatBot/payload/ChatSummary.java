package com.ai_ChatBot.payload;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ChatSummary {
    private Long id;
    private String title;
    private LocalDateTime updatedAt;
}
