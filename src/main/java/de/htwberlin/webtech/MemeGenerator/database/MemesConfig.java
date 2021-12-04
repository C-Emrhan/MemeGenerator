package de.htwberlin.webtech.MemeGenerator.database;

import de.htwberlin.webtech.MemeGenerator.database.MemeRepository;
import de.htwberlin.webtech.MemeGenerator.web.CreatedMeme;
import de.htwberlin.webtech.MemeGenerator.web.Memes;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MemesConfig {

    @Bean
    CommandLineRunner commandLineRunner(MemeRepository repository){
        return args -> {
            CreatedMeme m1 = new CreatedMeme(
                    "2L","Hallo"
            );

        };

    }
}