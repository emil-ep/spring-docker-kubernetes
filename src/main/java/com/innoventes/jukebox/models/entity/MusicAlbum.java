package com.innoventes.jukebox.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity(name = "tbl_music_album")
public class MusicAlbum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "genre")
    private String genre;

    @Column(name = "price")
    private Integer price;

    @Column(name = "date_of_release")
    private Date dateOfRelease;

    @Column(name = "description")
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "tbl_album_musicians",
            joinColumns = {@JoinColumn(name = "album_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "musician_id", referencedColumnName = "id")}
    )
    private Set<Musician> musician;

    public MusicAlbum() {
    }

    public MusicAlbum(String name, String genre, Integer price, String description, Date dateOfRelease, Set<Musician> musician) {
        this.name = name;
        this.genre = genre;
        this.price = price;
        this.description = description;
        this.dateOfRelease = dateOfRelease;
        this.musician = musician;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Musician> getMusician() {
        return musician;
    }

    public void setMusician(Set<Musician> musician) {
        this.musician = musician;
    }

    public Date getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(Date dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }
}
