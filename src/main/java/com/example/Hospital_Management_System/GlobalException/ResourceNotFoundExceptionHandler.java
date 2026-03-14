package com.example.Hospital_Management_System.GlobalException;

public class ResourceNotFoundExceptionHandler extends RuntimeException {
    public ResourceNotFoundExceptionHandler(String message){
        super(message);
    }
}
