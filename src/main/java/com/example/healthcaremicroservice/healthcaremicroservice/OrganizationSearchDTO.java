package com.example.healthcaremicroservice.healthcaremicroservice;

import java.util.Objects;

public class OrganizationSearchDTO {
    private String name;
    private String mainSpecialty;
    private String address;
    private int cvrNumber;
    private Long sorCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMainSpecialty() {
        return mainSpecialty;
    }

    public void setMainSpecialty(String mainSpecialty) {
        this.mainSpecialty = mainSpecialty;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCvrNumber() {
        return cvrNumber;
    }

    public void setCvrNumber(int cvrNumber) {
        this.cvrNumber = cvrNumber;
    }

    public Long getSorCode() {
        return sorCode;
    }

    public void setSorCode(Long sorCode) {
        this.sorCode = sorCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof OrganizationSearchDTO))
            return false;
        OrganizationSearchDTO organizationSearchDTO = (OrganizationSearchDTO) o;
        return Objects.equals(this.sorCode, organizationSearchDTO.sorCode)
                && Objects.equals(this.address, organizationSearchDTO.address)
                && Objects.equals(this.cvrNumber, organizationSearchDTO.cvrNumber)
                && Objects.equals(this.name, organizationSearchDTO.name)
                && Objects.equals(this.mainSpecialty, organizationSearchDTO.mainSpecialty);
    }
}
