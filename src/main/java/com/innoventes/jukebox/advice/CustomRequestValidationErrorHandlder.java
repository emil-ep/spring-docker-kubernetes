package com.innoventes.jukebox.advice;

import com.innoventes.jukebox.models.response.ErrorResponse;
import com.innoventes.jukebox.models.response.JukeboxResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Set;

@ControllerAdvice
public class CustomRequestValidationErrorHandlder {

    @ExceptionHandler
    public ResponseEntity<JukeboxResponse> handle(ConstraintViolationException exception) {
        Set<ConstraintViolation<?>> errorMessage = exception.getConstraintViolations();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(errorMessage));
    }
}
