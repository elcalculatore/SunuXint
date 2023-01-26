package com.example.demo.service;

import com.example.demo.modele.Message;
import com.example.demo.modele.User;
import com.example.demo.repository.MessageRepository;
import com.example.demo.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class MsgServiceImplement implements MessageService{
    private final UserRepository userRepository;
    private final MessageRepository messageRepository;

    @Override
    public List<Message> GetMessageEnvoyer(Long receiverId) {
        User receiver = userRepository.findById(receiverId)
                    .orElseThrow(() -> new EntityNotFoundException("Receiver not found"));
            return new ArrayList<>(receiver.getReceivedMessages());
        }

    @Override
    public List<Message> GetMessageRecu(Long senderId) {
        User sender = userRepository.findById(senderId)
                .orElseThrow(() -> new EntityNotFoundException("Sender not found"));
        return new ArrayList<>(sender.getSentMessages());
    }

    @Override
    public void envoyer(Message message) {
        User sender = userRepository.findById(message.getSender().getId())
                .orElseThrow(() -> new EntityNotFoundException("Sender not found"));
        User receiver = userRepository.findById(message.getReceiver().getId())
                .orElseThrow(() -> new EntityNotFoundException("Receiver not found"));

        message = new Message();
        message.setId(message.getId());
        message.setSender(sender);
        message.setReceiver(receiver);
        message.setContenu(message.getContenu());

        sender.getSentMessages().add(message);
        receiver.getReceivedMessages().add(message);

        messageRepository.save(message);
        userRepository.save(sender);
        userRepository.save(receiver);

    }
    @Override
    public String supMessage(Long id) {
          messageRepository.deleteById(id);
          return "Message supprime";
    }
}
