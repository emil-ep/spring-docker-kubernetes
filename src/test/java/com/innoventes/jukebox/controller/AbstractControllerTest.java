package com.innoventes.jukebox.controller;

import com.innoventes.jukebox.controller.helper.MusicianHelper;
import com.innoventes.jukebox.models.request.AlbumRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@AutoConfigureMockMvc
public class AbstractControllerTest {

    @MockBean
    protected MusicianHelper musicianHelper;

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    protected String getValidDateOfRelease(){
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        return LocalDate.parse("05-05-2021", formatter);
        return "2020";
    }

    protected AlbumRequest getAlbumRequest(Long id,String name, String dateOfRelease, String description, String genre,
                                           Integer price, List<Long> musicianIds){
        AlbumRequest albumRequest = new AlbumRequest();
        if (id != null)
            albumRequest.setId(id);
        albumRequest.setName(name);
        albumRequest.setDateOfRelease(dateOfRelease);
        albumRequest.setDescription(description);
        albumRequest.setGenre(genre);
        albumRequest.setPrice(price);
        albumRequest.setMusicianId(musicianIds);
        return albumRequest;
    }

}
