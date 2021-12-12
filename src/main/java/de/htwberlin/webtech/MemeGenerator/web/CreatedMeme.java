package de.htwberlin.webtech.MemeGenerator.web;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
public class CreatedMeme {
    @Id
    private String id;
    private String url;

    public CreatedMeme() {

    }

    public CreatedMeme(String id, String url){
        this.id = id;
        this.url = url;
    }

    public CreatedMeme(String url) {
        this.url = url;
    }
}
