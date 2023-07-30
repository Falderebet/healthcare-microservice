package com.example.healthcaremicroservice.healthcaremicroservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicRepository extends JpaRepository<Clinic, Long> {
}
