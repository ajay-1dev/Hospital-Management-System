package com.example.Hospital_Management_System.GlobalException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandling {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> ExceptionHandlerMethod(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(ex.getLocalizedMessage());
    }

    @ExceptionHandler(ResourceNotFoundExceptionHandler.class)
    public ResponseEntity<String> ResourceNotFound(ResourceNotFoundExceptionHandler ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(ex.getMessage());
    }
}
