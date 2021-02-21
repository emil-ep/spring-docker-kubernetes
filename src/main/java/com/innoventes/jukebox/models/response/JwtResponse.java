package com.innoventes.jukebox.models.response;

public class JwtResponse {

    private Integer id;

    private String token;

    private String email;

    public JwtResponse(Integer id, String token, String email){
        this.id = id;
        this.token = token;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
