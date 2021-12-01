package de.htwberlin.webtech.MemeGenerator.web;

import lombok.Data;

@Data
public class MemeResponse {

    private boolean success;

    private MemeResponseData data;

}