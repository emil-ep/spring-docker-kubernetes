package com.innoventes.jukebox.exceptions;

public class JukeBoxInternalServerException extends RuntimeException{

    private static final long serialVersionUID = 784623484384723L;

    public JukeBoxInternalServerException() {
    }

    public JukeBoxInternalServerException(String message) {
        super(message);
    }

    public JukeBoxInternalServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public JukeBoxInternalServerException(Throwable cause) {
        super(cause);
    }
}
