package com.innoventes.jukebox.batch;

import com.innoventes.jukebox.models.entity.Musician;
import com.innoventes.jukebox.repository.MusicianRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MusicianWriter implements ItemWriter<Musician> {

    @Autowired
    private MusicianRepository musicianRepository;

    @Override
    public void write(List<? extends Musician> list) throws Exception {
        musicianRepository.saveAll(list);
    }
}
