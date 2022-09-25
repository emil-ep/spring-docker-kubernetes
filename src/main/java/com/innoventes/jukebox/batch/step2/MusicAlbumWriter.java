package com.innoventes.jukebox.batch.step2;

import com.innoventes.jukebox.models.entity.MusicAlbum;
import com.innoventes.jukebox.repository.AlbumRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MusicAlbumWriter implements ItemWriter<MusicAlbum> {

    @Autowired
    private AlbumRepository musicAlbumRepository;

    @Override
    public void write(List<? extends MusicAlbum> list) throws Exception {
        musicAlbumRepository.saveAll(list);
    }
}
