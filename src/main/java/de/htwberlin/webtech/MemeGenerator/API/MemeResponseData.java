package de.htwberlin.webtech.MemeGenerator.API;

import de.htwberlin.webtech.MemeGenerator.web.Memes;
import lombok.Data;

import java.util.List;

@Data
public class MemeResponseData {

    private List<Memes> memes;

    public List<Memes> getMemes() {
        return memes;
    }

}
