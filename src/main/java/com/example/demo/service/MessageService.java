package com.example.demo.service;

import com.example.demo.modele.Message;

import java.util.List;

public interface MessageService {
    List<Message> GetMessageEnvoyer(Long id);
    List<Message> GetMessageRecu(Long id);
    void envoyer(Message message);

    String supMessage(Long id);
}
