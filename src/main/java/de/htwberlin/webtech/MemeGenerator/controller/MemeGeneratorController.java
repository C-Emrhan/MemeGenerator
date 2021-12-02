package de.htwberlin.webtech.MemeGenerator.controller;

import de.htwberlin.webtech.MemeGenerator.service.MemeService;
import de.htwberlin.webtech.MemeGenerator.API.MemeCaptionRequest;
import de.htwberlin.webtech.MemeGenerator.web.Memes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class MemeGeneratorController {

    private final MemeService memeService;

    public MemeGeneratorController(MemeService memeService) {
        this.memeService = memeService;
    }

    @GetMapping("memetemplates")
    public List<Memes> fetchMemeTemplates() {
        return memeService.fetchTemplates();
    }

    @GetMapping("caption")
    public HashMap<String, String> createCaptions(@RequestBody MemeCaptionRequest request) {
        return memeService.captionMeme(request);
    }

}