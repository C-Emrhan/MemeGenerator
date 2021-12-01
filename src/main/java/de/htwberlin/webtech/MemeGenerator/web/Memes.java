package de.htwberlin.webtech.MemeGenerator.web;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Memes {
    @Id
    private String id;
    private String name;
    private String url;

    public Memes() {

    }

    public Memes(String id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }


    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}