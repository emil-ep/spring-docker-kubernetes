package com.innoventes.jukebox.models.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.innoventes.jukebox.serializer.AlbumRequestSerializer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@JsonSerialize(using = AlbumRequestSerializer.class)
public class AlbumRequest {

    private Long id;

    @NotBlank(message = "name cannot be empty")
    @Size(min = 5, max = 100)
    private String name;

    private String genre;

    @NotNull(message = "Price cannot be empty")
    private Integer price;

    private String description;

    private String dateOfRelease;

    private List<Long> musicianId;

    public List<Long> getMusicianId() {
        return musicianId;
    }

    public void setMusicianId(List<Long> musicianId) {
        this.musicianId = musicianId;
    }

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

    public String getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(String dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
