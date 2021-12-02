package de.htwberlin.webtech.MemeGenerator.API;

import lombok.Data;

@Data
public class MemeResponse {

    private boolean success;

    private MemeResponseData data;

}