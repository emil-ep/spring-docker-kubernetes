package com.innoventes.jukebox.batch;

import com.innoventes.jukebox.models.entity.MusicAlbum;
import com.innoventes.jukebox.models.entity.Musician;
import com.innoventes.jukebox.repository.MusicianRepository;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;

public class MusicAlbumProcessor implements ItemProcessor<AlbumInput, MusicAlbum> {

    @Autowired
    private MusicianRepository musicianRepository;

    @Override
    public MusicAlbum process(AlbumInput albumInput) throws Exception {

        MusicAlbum album = new MusicAlbum();
        if (albumInput.getId() != null)
            album.setId(Long.valueOf(albumInput.getId()));
        if (albumInput.getArtist_id() != null){
            Musician musician = musicianRepository.getOne(Long.valueOf(albumInput.getArtist_id()));
            HashSet<Musician> musicianHashSet = new HashSet<>();
            musicianHashSet.add(musician);
            album.setMusician(musicianHashSet);
        }
        if (albumInput.getAlbum_title() != null)
            album.setName(albumInput.getAlbum_title());
        if (albumInput.getGenre() != null)
            album.setGenre(albumInput.getGenre());
        if (albumInput.getYear_of_pub() != null)
            album.setDateOfRelease(albumInput.getYear_of_pub());
        if (albumInput.getNum_of_tracks() != null)
            album.setNumberOfTracks(albumInput.getNum_of_tracks());
        if (albumInput.getNum_of_sales() != null)
            album.setNumberOfSales(albumInput.getNum_of_sales());
        if (albumInput.getRolling_stone_critic() != null)
            album.setRollingStoneCritic(Float.valueOf(albumInput.getRolling_stone_critic()));
        if (albumInput.getMtv_critic() != null)
            album.setMtvCritic(Float.valueOf(albumInput.getMtv_critic()));
        if (albumInput.getMusic_maniac_critic() != null)
            album.setMusicManiacCritic(Float.valueOf(albumInput.getMusic_maniac_critic()));

        return album;
    }
}
