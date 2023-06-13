package com.med.voll.api.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorException {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleError404 () {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleError400 (MethodArgumentNotValidException e) {
        var errors = e.getFieldErrors().stream().map(ErrorDto::new).toList();

        return ResponseEntity.badRequest().body(errors);
    }


    private record ErrorDto(String field, String message){
        public ErrorDto(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}
