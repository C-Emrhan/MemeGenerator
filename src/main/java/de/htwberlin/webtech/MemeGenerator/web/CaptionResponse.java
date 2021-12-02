package de.htwberlin.webtech.MemeGenerator.web;

import lombok.Data;

import java.util.HashMap;

@Data
public class CaptionResponse {
    private boolean success;

    private HashMap<String, String> data;

    private String error_message;
}
