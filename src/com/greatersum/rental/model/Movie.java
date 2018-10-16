package com.greatersum.rental.model;

import com.greatersum.rental.model.MovieCode;

public class Movie {
    private String id;
    private String title;
    private MovieCode code;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MovieCode getCode() {
        return code;
    }

    public void setCode(MovieCode code) {
        this.code = code;
    }
}
