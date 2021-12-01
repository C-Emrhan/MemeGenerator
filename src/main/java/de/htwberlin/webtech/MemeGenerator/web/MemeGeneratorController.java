package de.htwberlin.webtech.MemeGenerator.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class MemeRestController {

    private final MemeService memeService;

    public MemeRestController(MemeService memeService) {
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