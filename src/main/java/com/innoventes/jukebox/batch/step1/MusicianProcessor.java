package com.innoventes.jukebox.batch.step1;

import com.innoventes.jukebox.models.entity.Musician;
import org.springframework.batch.item.ItemProcessor;

public class MusicianProcessor implements ItemProcessor<MusicianInput, Musician> {
    @Override
    public Musician process(MusicianInput musicianInput) throws Exception {
        Musician musician = new Musician();
        if (musicianInput.getId() != null)
            musician.setId(Long.valueOf(musicianInput.getId()));
        if (musicianInput.getReal_name() != null)
            musician.setRealName(musicianInput.getReal_name());
        if (musicianInput.getArt_name() != null)
            musician.setName(musicianInput.getArt_name());
        if (musicianInput.getRole() != null)
            musician.setRole(musicianInput.getRole());
        if (musicianInput.getYear_of_birth() != null)
            musician.setYearOfBirth(Long.valueOf(musicianInput.getYear_of_birth()));
        if (musicianInput.getCountry() != null)
            musician.setCountry(musicianInput.getCountry());
        if (musicianInput.getCity() != null)
            musician.setCity(musicianInput.getCity());
        if (musicianInput.getEmail() != null)
            musician.setEmail(musicianInput.getEmail());
        if (musicianInput.getZip_code() != null)
            musician.setZipCode(musicianInput.getZip_code());

        return musician;
    }
}
