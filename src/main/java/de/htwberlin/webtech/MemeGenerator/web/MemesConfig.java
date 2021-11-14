package de.htwberlin.webtech.MemeGenerator.web;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MemesConfig {

    @Bean
    CommandLineRunner commandLineRunner(MemeRepository repository){
        return args -> {
            Memes m1 = new Memes(
                   2L, "testURL"
            );

            repository.saveAll(List.of(m1));
        };


    }
}
