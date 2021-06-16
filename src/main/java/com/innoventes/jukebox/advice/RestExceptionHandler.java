package com.innoventes.jukebox.advice;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.innoventes.jukebox.exceptions.JukeBoxInternalServerException;
import com.innoventes.jukebox.exceptions.JukeBoxUnauthorizedException;
import com.innoventes.jukebox.exceptions.JukeboxNotFoundException;
import com.innoventes.jukebox.models.response.ErrorResponse;
import com.innoventes.jukebox.models.response.JukeboxResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler  {


    @ExceptionHandler(value = {JukeBoxUnauthorizedException.class})
    public ResponseEntity<JukeboxResponse> handleUnAuthorizedException(JukeBoxUnauthorizedException exception){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(exception.getMessage()));
    }

    @ExceptionHandler(value = {InvalidFormatException.class})
    public ResponseEntity<JukeboxResponse> handleInvalidDateFormatException(InvalidFormatException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(exception.getMessage()));
    }

    @ExceptionHandler(value = {JukeBoxInternalServerException.class})
    public ResponseEntity<JukeboxResponse> handleInternalServerException(JukeBoxInternalServerException exception){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(exception.getMessage()));
    }

    @ExceptionHandler(value = {JukeboxNotFoundException.class})
    public ResponseEntity<JukeboxResponse> handleNotFoundException(JukeboxNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(exception.getMessage()));
    }

    @ExceptionHandler(value = {MaxUploadSizeExceededException.class})
    public ResponseEntity<JukeboxResponse> handleMaxUploadExceededException(MaxUploadSizeExceededException exception){
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ErrorResponse("File size is too large!"));
    }
}
