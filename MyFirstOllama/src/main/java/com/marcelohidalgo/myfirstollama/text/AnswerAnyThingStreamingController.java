package com.marcelohidalgo.myfirstollama.text;

import com.marcelohidalgo.myfirstollama.service.OllamaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class AnswerAnyThingStreamingController {

    private final OllamaService service;

    public AnswerAnyThingStreamingController(OllamaService service) {
        this.service = service;
    }

    @GetMapping("/stream")
    public Flux<String> askAnything(@RequestParam("message") String message) {
        return service.streamAnswer(message);
    }

}