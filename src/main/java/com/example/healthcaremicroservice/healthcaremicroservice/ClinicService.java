package com.example.healthcaremicroservice.healthcaremicroservice;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ClinicService {

    private static final Logger log = LoggerFactory.getLogger(ClinicService.class);
    private final ClinicRepository clinicRepository;
    private String[] HEADERS = { "Enhedsnavn", "Enhedstype"};

    @Autowired
    public ClinicService(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    @Transactional
    public void importCSV(String filePath) {
        log.info("Started populating database...");
        try (
                Reader reader1 = new BufferedReader(new FileReader(filePath));
        ) {

            CsvToBean<Clinic> csvReader = new CsvToBeanBuilder(reader1)
                    .withType(Clinic.class)
                    .withSeparator(';')
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Clinic> clinics = csvReader.parse();
            clinicRepository.saveAll(clinics);
            log.info("Finished populating the database");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<OrganizationSearchDTO> organizationSearch(int postalcode, String speciality) {
        List<Clinic> clinics = clinicRepository.findAll();
        List<OrganizationSearchDTO> searchResults = new ArrayList<>();

        for (Clinic c : clinics) {

            if (c.getPostalCode() != postalcode) {
                continue;
            }

            if (!(c.getMainSpeciality().equals(speciality))) {
                continue;
            }

            searchResults.add(mapToOrginazationSearchDTO(c));
        }

        return searchResults;
    }

    private OrganizationSearchDTO mapToOrginazationSearchDTO(Clinic c) {
        //TODO: Handle if any parameters are not "correct", example CVR="ingen"
        OrganizationSearchDTO org = new OrganizationSearchDTO();

        org.setAddress(c.getAddressLine());
        org.setCvrNumber(c.getCvr());
        org.setMainSpecialty(c.getMainSpeciality());
        org.setName(c.getOrganizationName());
        org.setSorCode(c.getSorCode());

        return org;
    }


    public Map<String, Map<String, Long>> getRegionStats() {
        List<Clinic> clinics = clinicRepository.findAll();

        // TODO: move the logic to clinicservice.

        // TODO: Missing domain knowledge to know when to count a clinic as 'private' or public.
        //  for now only "privat" is counted as private and "kommune" is counted as public.
        Map<String, Map<String, Long>> stats = clinics.stream()
                .collect(Collectors.groupingBy(Clinic::getRegion,
                        Collectors.groupingBy(Clinic::getClinicType, Collectors.counting())));

        Map<String, Map<String, Long>> sortedRegions = new HashMap<>();
        for (String region : stats.keySet()) {
            Map<String, Long> counts = stats.get(region);
            Map<String, Long> sortedCounts = new HashMap<>();

            sortedCounts.put("Private", counts.getOrDefault("privat", 0L));
            sortedCounts.put("Public", counts.getOrDefault("kommune", 0L));

            sortedRegions.put(region, sortedCounts);
        }

        // TODO: there needs to be filtering done to the sorted regions
        //  as there are regions which do not make sense to return.
        return sortedRegions;
    }
}
