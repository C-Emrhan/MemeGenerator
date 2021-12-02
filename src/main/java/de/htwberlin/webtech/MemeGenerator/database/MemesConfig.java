package de.htwberlin.webtech.MemeGenerator.database;

import de.htwberlin.webtech.MemeGenerator.database.MemeRepository;
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
            Memes m1 = new Memes(
                   "2L","Hallo", "testURL"
            );

            repository.saveAll(List.of(m1));
        };


    }
}
