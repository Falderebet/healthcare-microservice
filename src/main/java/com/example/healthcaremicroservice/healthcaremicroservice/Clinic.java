package com.example.healthcaremicroservice.healthcaremicroservice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Clinic {

    private @Id Long sorCode;
    private String region;
    private String clinicType;

    Clinic() {}

    Clinic(Long sorCode, String region, String clinicType) {
        this.sorCode = sorCode;
        this.region = region;
        this.clinicType = clinicType;
    }

    public Long getSorCode() {
        return this.sorCode;
    }

    public String getRegion() {
        return this.region;
    }

    public String getClinicType() {
        return this.clinicType;
    }

    public void setSorCode(Long sorCode) {
        this.sorCode = sorCode;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setClinicType(String clinicType) {
        this.clinicType = clinicType;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Clinic))
            return false;
        Clinic clinic = (Clinic) o;
        return Objects.equals(this.sorCode, clinic.sorCode) && Objects.equals(this.clinicType, clinic.clinicType)
                && Objects.equals(this.region, clinic.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.sorCode, this.clinicType, this.region);
    }

    @Override
    public String toString() {
        return "Clinic{" + "SOR-code=" + this.sorCode + ", clinic type=" + this.clinicType + ", region=" + this.region;
    }
}
