package com.example.healthcaremicroservice.healthcaremicroservice;

import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @CsvBindByName(column = "SOR-kode")
    private Long sorCode;

    @CsvBindByName(column = "P_Region")
    private String region;

    @CsvBindByName(column = "Enhedstype")
    private String clinicType;

    @CsvBindByName(column = "Hovedspeciale")
    private String mainSpeciality;

    @CsvBindByName(column = "CVR")
    private int cvr;

    @CsvBindByName(column = "Telefon")
    private String phoneNumber;

    @CsvBindByName(column = "E-mail")
    private String email;

    @CsvBindByName(column = "Hjemmeside")
    private String homepage;

    @CsvBindByName(column = "P_Postnummer")
    private int postalCode;

    @CsvBindByName(column = "P_By")
    private String city;

    @CsvBindByName(column = "Postadresse")
    private String addressLine;

    @CsvBindByName(column = "Enhedsnavn")
    private String organizationName;

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Clinic() {}

    public Clinic(Long sorCode, String region, String clinicType, String mainSpeciality, int cvr, String phoneNumber,
                  String email, String homepage, int postalCode, String city,
                  String addressLine, String organizationName) {
        this.sorCode = sorCode;
        this.region = region;
        this.clinicType = clinicType;
        this.mainSpeciality = mainSpeciality;
        this.cvr = cvr;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.homepage = homepage;
        this.postalCode = postalCode;
        this.city = city;
        this.addressLine = addressLine;
        this.organizationName = organizationName;
    }

    @Override
    public String toString() {
        return "Clinic{" +
                "sorCode=" + sorCode +
                ", region='" + this.region + '\'' +
                ", clinicType='" + clinicType + '\'' +
                ", mainSpeciality='" + mainSpeciality + '\'' +
                ", cvr=" + cvr +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", homepage='" + homepage + '\'' +
                ", postalCode=" + postalCode +
                ", city='" + city + '\'' +
                ", addressLine='" + addressLine + '\'' +
                ", organizationName='" + organizationName + '\'' +
                '}';
    }

    /*
    Clinic(Long sorCode, String region, String clinicType) {
        this.sorCode = sorCode;
        this.region = region;
        this.clinicType = clinicType;
    }
    */

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

    // TODO: update equals for Clinic.
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

    // TODO: update hashcode generation of Clinics.
    @Override
    public int hashCode() {
        return Objects.hash(this.sorCode, this.clinicType, this.region);
    }

}
