package com.innoventes.jukebox.models.response;

public class JukeboxResponse {

    protected Object body;

    public JukeboxResponse(Object body) {
        this.body = body;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
