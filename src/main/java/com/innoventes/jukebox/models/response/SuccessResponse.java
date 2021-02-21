package com.innoventes.jukebox.models.response;


public class SuccessResponse extends JukeboxResponse{

    private static final int status = 1;

    public SuccessResponse(Object body) {
        super(body);
    }

    public static int getStatus() {
        return status;
    }
}
