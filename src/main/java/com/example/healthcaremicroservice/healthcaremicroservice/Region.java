package com.example.healthcaremicroservice.healthcaremicroservice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Region {

    private @Id @GeneratedValue Long id;
    private String region;
    private int privateClinics;
    private int publicClinics;

    Region() {}

    public Region(Long id, String region, int privateClinics, int publicClinics) {
        this.id = id;
        this.region = region;
        this.privateClinics = privateClinics;
        this.publicClinics = publicClinics;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getPrivateClinics() {
        return privateClinics;
    }

    public void setPrivateClinics(int privateClinics) {
        this.privateClinics = privateClinics;
    }

    public int getPublicClinics() {
        return publicClinics;
    }

    public void setPublicClinics(int publicClinics) {
        this.publicClinics = publicClinics;
    }
}
