package com.example.healthcaremicroservice.healthcaremicroservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClinicServiceTest {
    private final ClinicRepository repository = mock(ClinicRepository.class);

    @BeforeEach
    public void setUp() {
        Clinic clinic = generateClinic();

        List<Clinic> clinics = new ArrayList<>();
        clinics.add(clinic);

        when(repository.findAll()).thenReturn(clinics);
    }

    @Test
    public void testOrganizationSearch() {
        ClinicService service = new ClinicService(repository);
        List<OrganizationSearchDTO> orgs = service.organizationSearch(8000, "ordontologi");

        // Not an optimal way, however it showcases the use of a mock repository and test setup.
        OrganizationSearchDTO org = new OrganizationSearchDTO();
        org.setName("Lars Larsen Læge");
        org.setMainSpecialty("ordontologi");
        org.setCvrNumber(0);
        org.setAddress("Aarhusvej 10");
        org.setSorCode(88888888L);

        assertEquals(orgs.get(0), org);
    }


    private Clinic generateClinic() {
        // Can be made in many different ways depending on what kind of test you want to perform.

        Clinic c = new Clinic();
        c.setCity("Aarhus");
        c.setRegion("Region Midtjylland");
        c.setClinicType("privat");
        c.setOrganizationName("Lars Larsen Læge");
        c.setPostalCode(8000);
        c.setPhoneNumber("+4588888888");
        c.setMainSpeciality("ordontologi");
        c.setHomepage("google.com");
        c.setAddressLine("Aarhusvej 10");
        c.setSorCode(88888888L);
        c.setEmail("lars@gmail.com");
        c.setCvr(0);

        return c;
    }
}
