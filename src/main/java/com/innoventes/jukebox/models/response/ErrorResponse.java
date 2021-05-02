package com.innoventes.jukebox.models.response;

public class ErrorResponse extends JukeboxResponse{

    private int status = 0;

    public ErrorResponse(Object body) {
        super(body);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
