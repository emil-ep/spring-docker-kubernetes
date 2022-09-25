package com.innoventes.jukebox.models;

public enum MusicianTypes {


    FOLK("Folk", 7),
    METAL("Metal", 8),
    LATINO("Latino", 9),
    POP("Pop", 3),
    BLACK_METAL("Black Metal", 10),
    PROGRESSIVE("Progressive", 11),
    POP_ROCK("Pop-Rock", 12),
    RETRO("Retro", 13),
    WESTERN("Western", 14),
    K_POP("K-Pop", 15),
    INDIE("Indie", 16),
    LOUNGE("Lounge", 17),
    J_ROCK("J-Rock", 18),
    HARD_ROCK("Hard Rock", 19),
    UNPLUGGED("Unplugged", 20),
    ALTERNATIVE("Alternative", 21),
    DEATH_METAL("Death Metal", 22),
    TRAP("Trap", 23),
    COMPILATION("Compilation", 24),
    BLUES("Blues", 25),
    GOSPEL("Gospel", 26),
    AMBIENT("Ambient", 27),
    COUNTRY("Country", 28);




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
