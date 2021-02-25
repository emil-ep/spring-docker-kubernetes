package com.innoventes.jukebox.models.request;


import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

public class MusicianRequest {

    @Nullable
    private Long id;

    @NotBlank(message = "Name must not be empty")
    @Size(min = 3, max = 50)
    private String name;

    private String type;

    private List<Long> albumIds;

    public List<Long> getAlbumIds() {
        return albumIds;
    }

    public void setAlbumIds(List<Long> albumIds) {
        this.albumIds = albumIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Nullable
    public Long getId() {
        return id;
    }

    public void setId(@Nullable Long id) {
        this.id = id;
    }
}
