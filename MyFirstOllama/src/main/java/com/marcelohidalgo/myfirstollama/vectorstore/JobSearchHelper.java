package com.marcelohidalgo.myfirstollama.vectorstore;

import com.marcelohidalgo.myfirstollama.service.OllamaService;
import org.springframework.ai.document.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class JobSearchHelper {

    private final OllamaService service;

    public JobSearchHelper(OllamaService service) {
        this.service = service;
    }

    @GetMapping("/showJobSearchHelper")
    public String showJobSearchHelper() {
        return "jobSearchHelper";

    }

    @PostMapping("/jobSearchHelper")
    public String jobSearchHelper(@RequestParam String query, Model model) {
        List<Document> response = service.searchJobs(query);
        model.addAttribute("response", response);
        return "jobSearchHelper";
    }

}