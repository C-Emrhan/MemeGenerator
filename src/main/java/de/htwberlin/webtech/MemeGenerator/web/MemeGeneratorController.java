package de.htwberlin.webtech.MemeGenerator.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MemeGeneratorController {

    @GetMapping(path = "/")
    public ModelAndView showMeme(){
        return new ModelAndView("MemeGenerator");
    }
}
