package com.ai_ChatBot.service.Impl;

import com.ai_ChatBot.entity.Chat;
import com.ai_ChatBot.entity.Message;
import com.ai_ChatBot.payload.ChatRequest;
import com.ai_ChatBot.payload.ChatResponse;
import com.ai_ChatBot.repository.ChatRepository;
import com.ai_ChatBot.repository.MessageRepository;
import com.ai_ChatBot.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatClient chatClient;
    private final ChatRepository chatRepository;
    private final MessageRepository messageRepository;

    @Override
    public Flux<String> streamChat(String message) {
        return chatClient.prompt()
                .user(message)
                .stream()
                .content();
    }

    @Override
    public ChatResponse sendMessage(ChatRequest request) {

        Chat chat;

        if (request.getChatId() == null) {
            // New chat — title = first 50 chars of message
            String title = request.getMessage().length() > 50
                    ? request.getMessage().substring(0, 50) + "…"
                    : request.getMessage();

            chat = Chat.builder()
                    .title(title)
                    .build();

            chat = chatRepository.save(chat);
        } else {
            chat = chatRepository.findById(request.getChatId())
                    .orElseThrow(() -> new RuntimeException("Chat not found: " + request.getChatId()));
        }

        // Save USER message
        messageRepository.save(Message.builder()
                .chat(chat)
                .role("USER")
                .content(request.getMessage())
                .build());

        // Call AI
        String aiReply = chatClient.prompt()
                .user(request.getMessage())
                .call()
                .content();

        // Save ASSISTANT message
        messageRepository.save(Message.builder()
                .chat(chat)
                .role("ASSISTANT")
                .content(aiReply)
                .build());

        return new ChatResponse(aiReply, chat.getId());
    }
}