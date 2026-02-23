package com.marcelohidalgo.myfirstollama.rag;

import com.marcelohidalgo.myfirstollama.service.OllamaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductDataBotController {

    private final OllamaService service;

    public ProductDataBotController(OllamaService service) {
        this.service = service;
    }

    @GetMapping("/showProductDataBot")
    public String showProductDataBot() {
        return "productDataBot";
    }

    @PostMapping("/productDataBot")
    public String productDataBot(@RequestParam String query, Model model) {
        model.addAttribute("response", service.answer(query));
        return "productDataBot";
    }

}