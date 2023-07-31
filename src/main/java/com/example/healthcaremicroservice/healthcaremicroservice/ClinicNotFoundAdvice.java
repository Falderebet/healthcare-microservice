package com.example.healthcaremicroservice.healthcaremicroservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ClinicNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ClinicNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String clinicNotFoundHandler(ClinicNotFoundException ex) {
        return ex.getMessage();
    }
}
