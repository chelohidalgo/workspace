package com.marcelohidalgo.myfirstollama.tools;

import com.marcelohidalgo.myfirstollama.service.OllamaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherAgentController {

    private final OllamaService service;

    public WeatherAgentController(OllamaService service) {
        this.service = service;
    }

    @GetMapping("/showWeatherAgent")
    public String showWeatherAgent() {
        return "weatherTool";
    }

    @PostMapping("/weatherAgent")
    public String weatherAgent(@RequestParam("query") String query, Model model) {
        String response = service.callAgent(query);
        model.addAttribute("weatherInfo", response);
        return "weatherTool";
    }
}