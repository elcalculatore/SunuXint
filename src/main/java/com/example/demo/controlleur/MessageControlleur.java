package com.example.demo.controlleur;
import com.example.demo.modele.Message;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/message")
@AllArgsConstructor
public class MessageControlleur {
    private final MessageService messageService;
    @PostMapping("/send")
    public void send(@RequestBody Message message) {
        messageService.envoyer(message);
    }

    @GetMapping("/envoyer/{id}")
    public List<Message> read_sent(@PathVariable Long id) {
        return messageService.GetMessageEnvoyer(id);
    }

    @GetMapping("/recu/{id}")
    public List<Message> read_receive(@PathVariable Long id) {
        return messageService.GetMessageRecu(id);
    }

    @DeleteMapping("/delete")
    public String delete(@PathVariable Long id) {
        return messageService.supMessage(id);
    }
}
