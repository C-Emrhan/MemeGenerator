package de.htwberlin.webtech.MemeGenerator.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@RestController
@RequestMapping(path = "get_memes")
public class MemeGeneratorController {

    private final MemeService memeService;
    @Autowired
    public MemeGeneratorController(MemeService memeService) {
        this.memeService = memeService;
    }

    @GetMapping
    public List<Memes> getMemes(){
        return memeService.getMemes();
    }
}
