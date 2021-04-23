package com.innoventes.jukebox.advice;

import com.innoventes.jukebox.exceptions.JukeBoxUnauthorizedException;
import com.innoventes.jukebox.models.response.ErrorResponse;
import com.innoventes.jukebox.models.response.JukeboxResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler  {

//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//                                                                  HttpHeaders headers, HttpStatus status,
//                                                                  WebRequest request) {
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ex.getAllErrors().get(0).getDefaultMessage()));
//    }

    @ExceptionHandler(value = {JukeBoxUnauthorizedException.class})
    public ResponseEntity<JukeboxResponse> handleUnAuthorizedException(JukeBoxUnauthorizedException exception){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(exception.getMessage()));
    }

}
