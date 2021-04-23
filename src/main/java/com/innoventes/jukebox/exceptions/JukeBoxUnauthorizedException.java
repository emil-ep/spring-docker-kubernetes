package com.innoventes.jukebox.exceptions;

public class JukeBoxUnauthorizedException extends RuntimeException{

    private static final long serialVersionUID = 3231324329208948384L;

    public JukeBoxUnauthorizedException() {
        super();
    }

    public JukeBoxUnauthorizedException(String message) {
        super(message);
    }

    public JukeBoxUnauthorizedException(String message, Throwable cause) {
        super(message, cause);
    }
}
