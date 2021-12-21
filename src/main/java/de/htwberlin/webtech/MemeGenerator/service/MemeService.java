package de.htwberlin.webtech.MemeGenerator.service;

import de.htwberlin.webtech.MemeGenerator.API.CaptionResponse;
import de.htwberlin.webtech.MemeGenerator.API.MemeCaptionRequest;
import de.htwberlin.webtech.MemeGenerator.API.MemeResponse;
import de.htwberlin.webtech.MemeGenerator.database.MemeRepository;
import de.htwberlin.webtech.MemeGenerator.web.CreatedMeme;
import de.htwberlin.webtech.MemeGenerator.web.Memes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class MemeService {

    private final MemeRepository memeRepository;
    private final RestTemplate restTemplate;


    @Autowired
    public MemeService(MemeRepository memeRepository, RestTemplate restTemplate) {
        this.memeRepository = memeRepository;
        this.restTemplate = restTemplate;
    }

    public List<CreatedMeme> getMemes(){
        return memeRepository.findAll();
    }

    public List<Memes> fetchTemplates() {
        ResponseEntity<MemeResponse> response = restTemplate.getForEntity("https://api.imgflip.com/get_memes", MemeResponse.class);
        MemeResponse memeResponse = response.getBody();
        return memeResponse != null? memeResponse.getData().getMemes() : Collections.emptyList();
    }

    public HashMap<String, String> captionMeme(MemeCaptionRequest captionRequest) {
        final String url = "https://api.imgflip.com/caption_image?text0="+captionRequest.getTx0()+"&text1="
                +captionRequest.getTx1()+"&username=" + captionRequest.getUsername() + "&password="
                + captionRequest.getPassword() + "&template_id=" + captionRequest.getId();

        final ResponseEntity<CaptionResponse> response = restTemplate.postForEntity(url, new LinkedMultiValueMap<>(), CaptionResponse.class);
        CreatedMeme createdMeme = new CreatedMeme();
        createdMeme.setUrl(response.getBody().getData().get("url"));
        if (response.getBody() != null) {
            System.out.println(response.getBody().getError_message());
            memeRepository.save(createdMeme);
            return response.getBody().getData();
        } else throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }


}
