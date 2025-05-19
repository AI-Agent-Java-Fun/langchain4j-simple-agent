package org.example.controller;

import org.example.service.AiServiceForDice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Небольшой контроллер для взаимодействия с агентом.
 */
@RestController
public class ChatController {

    AiServiceForDice aiServiceForDice;

    public ChatController(AiServiceForDice aiServiceForDice) {
        this.aiServiceForDice = aiServiceForDice;
    }

    @PostMapping("/chat")
    String chat(@RequestBody String message) {
        return aiServiceForDice.chat(message);
    }
}
