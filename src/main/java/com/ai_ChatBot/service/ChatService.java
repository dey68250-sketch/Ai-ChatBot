package com.ai_ChatBot.service;

import com.ai_ChatBot.payload.ChatRequest;
import com.ai_ChatBot.payload.ChatResponse;
import reactor.core.publisher.Flux;

public interface ChatService {

    Flux<String> streamChat(String message);

    ChatResponse sendMessage(ChatRequest request);

}
