package de.htwberlin.webtech.MemeGenerator.web;

import lombok.Data;

@Data
public class MemeCaptionRequest {
    private String id;
    private String username;
    private String password;
    private String tx0;
    private String tx1;
}
