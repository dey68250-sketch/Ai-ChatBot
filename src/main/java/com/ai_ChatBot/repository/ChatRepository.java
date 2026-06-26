package com.ai_ChatBot.repository;

import com.ai_ChatBot.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Long> {

    List<Chat> findAllByOrderByUpdatedAtDesc();
}