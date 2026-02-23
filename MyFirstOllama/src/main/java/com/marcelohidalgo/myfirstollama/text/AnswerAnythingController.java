package com.marcelohidalgo.myfirstollama.text;

import com.marcelohidalgo.myfirstollama.service.OllamaService;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AnswerAnythingController {

    private final OllamaService service;

    public AnswerAnythingController(OllamaService service) {
        this.service = service;
    }

    @GetMapping
    public String showAnythingPage() {
        return "askAnything";
    }

    @PostMapping("/askAnything")
    public String askAnything(@RequestParam("question") String question, Model model) {
        ChatResponse response = service.generateAnswer(question);
        model.addAttribute("question", question);
        model.addAttribute("answer", response.getResult().getOutput().getText());
        return "askAnything";
    }
}
