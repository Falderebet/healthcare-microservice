package com.example.healthcaremicroservice.healthcaremicroservice;

public class ClinicNotFoundException extends RuntimeException {
    ClinicNotFoundException(Long sorcode) {
        super("Could not find clinic with sorcode " + sorcode);
    }
}
