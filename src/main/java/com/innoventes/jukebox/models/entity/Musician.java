package com.innoventes.jukebox.models.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "tbl_musician")
public class Musician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "musician")
    Set<MusicAlbum> albums;

    public Musician(String type, String name, Set<MusicAlbum> albums) {
        this.type = type;
        this.name = name;
        this.albums = albums;
    }

    public Musician() {
    }

    public Set<MusicAlbum> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<MusicAlbum> albums) {
        this.albums = albums;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
