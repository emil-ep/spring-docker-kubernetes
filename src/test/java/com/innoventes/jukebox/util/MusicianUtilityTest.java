package com.innoventes.jukebox.util;

import com.innoventes.jukebox.models.MusicianTypes;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MusicianUtilityTest {


    @Test
    public void validateMusicianTypeForValidType(){
        boolean isValidMusicianType = MusicianUtility.validateMusicianType(MusicianTypes.POP.getMusicianType());
        assertTrue(isValidMusicianType);
    }

    @Test
    public void validateMusicianTypeForInvalidType(){
        boolean isValidMusicianType = MusicianUtility.validateMusicianType("Invalid");
        assertFalse(isValidMusicianType);
    }
}
