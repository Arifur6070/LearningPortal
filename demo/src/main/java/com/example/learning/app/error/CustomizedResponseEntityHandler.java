package com.example.learning.app.error;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomizedResponseEntityHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleInvalidArgument(MethodArgumentNotValidException ex){
        Map<String,String> erroMap = new HashMap<>();

        System.out.println("Inside here");
        ex.getBindingResult().getFieldErrors().forEach(
            error ->{
                erroMap.put(error.getField(), error.getDefaultMessage());
            }
        );


        return erroMap;
    }
    
}
