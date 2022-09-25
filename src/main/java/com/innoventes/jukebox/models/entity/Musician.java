package com.innoventes.jukebox.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "tbl_musician")
public class Musician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "real_name")
    private String realName;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "role")
    private String role;

    @Column(name = "year_of_birth")
    private Long yearOfBirth;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "email")
    private String email;

    @Column(name = "zip_code")
    private String zipCode;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "musician")
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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Long yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
