package de.htwberlin.webtech.MemeGenerator.controller;

import de.htwberlin.webtech.MemeGenerator.service.MemeService;
import de.htwberlin.webtech.MemeGenerator.API.MemeCaptionRequest;
import de.htwberlin.webtech.MemeGenerator.web.CreatedMeme;
import de.htwberlin.webtech.MemeGenerator.web.Memes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

@RestController
public class MemeGeneratorController {

    private final MemeService memeService;

    public MemeGeneratorController(MemeService memeService) {
        this.memeService = memeService;
    }

    @GetMapping("/api/v1/memetemplates")
    public List<Memes> fetchMemeTemplates() {
        return memeService.fetchTemplates();
    }

    @GetMapping("/api/v1/created")
    public List<CreatedMeme> getMemes(){
        return memeService.displayMemes();
    }

    @PostMapping("/api/v1/caption")
    public HashMap<String, String> createCaptions(@RequestBody MemeCaptionRequest request) {
        return memeService.captionMeme(request);
    }
}
