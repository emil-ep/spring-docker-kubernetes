package com.innoventes.jukebox.exceptions;

public class JukeboxNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 784623214384723L;

    public JukeboxNotFoundException() {
    }

    public JukeboxNotFoundException(String message) {
        super(message);
    }

    public JukeboxNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public JukeboxNotFoundException(Throwable cause) {
        super(cause);
    }
}
