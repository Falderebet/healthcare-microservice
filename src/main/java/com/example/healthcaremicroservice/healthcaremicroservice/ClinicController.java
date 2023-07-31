package com.example.healthcaremicroservice.healthcaremicroservice;

import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class ClinicController {
    private final ClinicRepository repository;
    private final ClinicService service;

    //TODO: 'æøå' not showing properly in http response.
    ClinicController(ClinicRepository repository, ClinicService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping("/stats")
    Map<String, Map<String, Long>> getRegionStats() {
        // TODO: error handling / edge case handling.
        return service.getRegionStats();
    }

    @GetMapping("/search")
    List<OrganizationSearchDTO> organizationSearch(
            @RequestParam("postalcode") int postalcode,
            @RequestParam("speciality") String speciality
    ) {
        return service.organizationSearch(postalcode, speciality);
    }

    @GetMapping("/lookup/{sorcode}")
    EntityModel<Clinic> lookUpClinic(@PathVariable Long sorcode) {
        Clinic clinic = repository.findById(sorcode)
                .orElseThrow(() -> new ClinicNotFoundException(sorcode));

        //TODO: figure out what makes sense to link to.
        return EntityModel.of(clinic,
                linkTo(methodOn(ClinicController.class).lookUpClinic(sorcode)).withSelfRel(),
                linkTo(methodOn(ClinicController.class).getRegionStats()).withRel("regionstats"),
                linkTo(methodOn(ClinicController.class).organizationSearch(clinic.getPostalCode(),
                        clinic.getMainSpeciality())).withRel("organizationsearch"));
    }
}
