package com.ai_ChatBot.controller;

import com.ai_ChatBot.entity.Message;
import com.ai_ChatBot.payload.ChatRequest;
import com.ai_ChatBot.payload.ChatResponse;
import com.ai_ChatBot.payload.ChatSummary;
import com.ai_ChatBot.repository.ChatRepository;
import com.ai_ChatBot.repository.MessageRepository;
import com.ai_ChatBot.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class ChatController {

    private final ChatService chatService;
    private final ChatRepository chatRepository;
    private final MessageRepository messageRepository;

    @PostMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamChat(@RequestBody String message) {
        return chatService.streamChat(message);
    }

    @PostMapping("/send")
    public ChatResponse sendMessage(@RequestBody ChatRequest request) {
        return chatService.sendMessage(request);
    }

    // Returns only id + title + updatedAt (no messages loaded)
    @GetMapping("/all")
    public List<ChatSummary> getAllChats() {
        return chatRepository.findAllByOrderByUpdatedAtDesc()
                .stream()
                .map(c -> new ChatSummary(c.getId(), c.getTitle(), c.getUpdatedAt()))
                .toList();
    }

    @GetMapping("/{chatId}/messages")
    public List<Message> getMessages(@PathVariable Long chatId) {
        return messageRepository.findByChatIdOrderByCreatedAtAsc(chatId);
    }

    @DeleteMapping("/{chatId}")
    public void deleteChat(@PathVariable Long chatId) {
        chatRepository.deleteById(chatId);
    }
}