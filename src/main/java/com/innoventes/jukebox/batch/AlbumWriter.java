package com.innoventes.jukebox.batch;

import com.innoventes.jukebox.models.entity.MusicAlbum;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlbumWriter implements ItemWriter<MusicAlbum> {
    @Override
    public void write(List<? extends MusicAlbum> list) throws Exception {
        for (MusicAlbum album : list){

        }

    }
}
