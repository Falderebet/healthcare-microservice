package com.example.healthcaremicroservice.healthcaremicroservice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Clinic {

    private @Id Long sorCode;
    private String region;
    private String clinicType;
    private String mainSpeciality;
    private int cvr;
    private String phoneNumber;
    private String email;
    private String homepage;
    private int postalCode;
    private String city;
    private String addressLine;
    private String organizationName;

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Clinic() {}

    Clinic(Long sorCode, String region, String clinicType) {
        this.sorCode = sorCode;
        this.region = region;
        this.clinicType = clinicType;
    }

    public String getMainSpeciality() {
        return mainSpeciality;
    }

    public void setMainSpeciality(String mainSpeciality) {
        this.mainSpeciality = mainSpeciality;
    }

    public void setCvr(int cvr) {
        this.cvr = cvr;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
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

    public int getCvr() {
        return cvr;
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
