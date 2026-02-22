package com.marcelohidalgo.myfirstollama.promptemplate;

import com.marcelohidalgo.myfirstollama.service.OllamaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InterviewHelper {

    private final OllamaService service;

    public InterviewHelper(OllamaService service) {
        this.service = service;
    }

    @GetMapping("/showInterviewHelper")
    public String showInterviewHelper() {
        return "interviewHelper";
    }

    @PostMapping("/interviewHelper")
    public String interviewHelper(@RequestParam("company") String company,
                                  @RequestParam("jobTitle") String jobTitle,
                                  @RequestParam("strength") String strength,
                                  @RequestParam("weakness") String weakness, Model model) {
        String response = service.getInterview(company, jobTitle, strength, weakness);
        model.addAttribute("response",response);
        return "interviewHelper";
    }
}
