package de.htwberlin.webtech.MemeGenerator.web;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Memes {
    @Id
    private Long id;
    private String url;

    public Memes() {

    }

    public Memes(Long id, String url) {
        this.id = id;
        this.url = url;
    }


    public Long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Memes{" +
                "id=" + id +
                ", url='" + url + '\'' +
                '}';
    }
}
