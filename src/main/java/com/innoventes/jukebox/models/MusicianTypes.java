package com.innoventes.jukebox.models;

public enum MusicianTypes {

    ROCK_BAND("Rock Band", 1),
    COMPOSER("Composer", 2),
    POP("Pop", 3),
    COVER_ARTIST("Cover Artist", 4),
    METAL_BAND("Metal Band", 5),
    RAP_ARTIST("Rapper", 6);

    private String musicianType;
    private Integer typeId;


    MusicianTypes(String type, Integer id) {
        this.musicianType = type;
        this.typeId = id;
    }

    public String getMusicianType(){
        return musicianType;
    }

    public Integer getMusicianTypeId(){
        return typeId;
    }
}
