package com.innoventes.jukebox.models.request;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class MusicianRequest {

    @NotBlank(message = "Name must not be empty")
    @Size(min = 3, max = 50)
    private String name;

    private String type;

    public MusicianRequest(@NotBlank(message = "Name must not be empty") @Size(min = 3, max = 50) String name, String type) {
        this.name = name;
        this.type = type;
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
}
