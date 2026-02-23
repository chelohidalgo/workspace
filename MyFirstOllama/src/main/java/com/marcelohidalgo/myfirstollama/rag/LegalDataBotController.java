package com.marcelohidalgo.myfirstollama.rag;

import com.marcelohidalgo.myfirstollama.service.OllamaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LegalDataBotController {

    private final OllamaService service;

    public LegalDataBotController(OllamaService service) {
        this.service = service;
    }

    @GetMapping("/showLegalDataBot")
    public String showLegalDataBot() {
        return "legalDataBot";
    }

    @PostMapping("/legalDataBot")
    public String legalDataBot(@RequestParam String query, Model model) {
        model.addAttribute("response", service.answerLegal(query));
        return "legalDataBot";
    }
}
