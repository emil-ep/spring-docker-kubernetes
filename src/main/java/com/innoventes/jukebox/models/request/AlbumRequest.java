package com.innoventes.jukebox.models.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AlbumRequest {

    @NotBlank(message = "name cannot be empty")
    private String name;

    private String genre;

    @NotNull(message = "Price cannot be empty")
    private Integer price;

    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
