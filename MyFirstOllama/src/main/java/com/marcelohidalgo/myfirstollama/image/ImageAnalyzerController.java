package com.marcelohidalgo.myfirstollama.image;

import com.marcelohidalgo.myfirstollama.service.OllamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Controller
public class ImageAnalyzerController {

    // Define the folder where images will be saved
    //private static final String UPLOAD_DIR = "/Users/marcelonisum/Downloads/";

    @Autowired
    private OllamaService service;

    // Display the image upload form
    @GetMapping("showImageAnalyzer")
    public String showUploadForm() {
        return "imageAnalyzer";
    }

    @PostMapping("/imageAnalyzer")
    public String uploadImage(String prompt, @RequestParam("file") MultipartFile file, Model model, RedirectAttributes redirectAttributes, @Value("${file.upload.dir}") String fileUploadDir) {
        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a file to upload");
            return "imageAnalyzer";
        }

        try {
            // Ensure the directory exists
            //Path uploadDir = Paths.get(UPLOAD_DIR);
            Path uploadDir = Paths.get(fileUploadDir).toAbsolutePath().normalize();
            if (Files.notExists(uploadDir)) {
                Files.createDirectories(uploadDir); // Create the directory if it doesn't exist
            }

            // Save the uploaded file to the specified directory
            Path path = uploadDir.resolve(file.getOriginalFilename());
            Files.write(path, file.getBytes(), StandardOpenOption.CREATE);
            // Generate explanation and add to the model

            System.out.println("starting anayzing file" + path.toString());
            String response = service.explainImage(prompt, path.toString());
            model.addAttribute("explanation",response);
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "Failed to upload file");
        }

        return "imageAnalyzer";
    }
}