package com.innoventes.jukebox.advice;

import com.innoventes.jukebox.exceptions.JukeBoxUnauthorizedException;
import com.innoventes.jukebox.models.response.ErrorResponse;
import com.innoventes.jukebox.models.response.JukeboxResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler  {


    @ExceptionHandler(value = {JukeBoxUnauthorizedException.class})
    public ResponseEntity<JukeboxResponse> handleUnAuthorizedException(JukeBoxUnauthorizedException exception){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(exception.getMessage()));
    }

}
