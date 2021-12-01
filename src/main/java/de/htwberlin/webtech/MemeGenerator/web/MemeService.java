package de.htwberlin.webtech.MemeGenerator.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class MemeService {

    private final MemeRepository memeRepository;

    @Autowired
    public MemeService(MemeRepository memeRepository) {
        this.memeRepository = memeRepository;
    }

    public List<Memes> getMemes(){
     return memeRepository.findAll();
    }
}