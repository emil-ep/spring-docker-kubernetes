package com.innoventes.jukebox.util;

import com.innoventes.jukebox.models.MusicianTypes;

import java.util.Arrays;
import java.util.Optional;

public class MusicianUtility {


    public static Boolean validateMusicianType(String musicianType){
        MusicianTypes[] types = MusicianTypes.values();
        Optional<MusicianTypes> musicianTypesOptional = Arrays.stream(types)
                .filter(type -> type.getMusicianType().equals(musicianType))
                .findFirst();
        return musicianTypesOptional.isPresent();
    }
}
