package com.example.healthcaremicroservice.healthcaremicroservice;

import jakarta.transaction.Transactional;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

@Service
public class ClinicService {
    private final ClinicRepository clinicRepository;
    private String[] HEADERS = { "Enhedsnavn", "Enhedstype"};

    @Autowired
    public ClinicService(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    @Transactional
    public void importCSV(String filePath) {

        try (Reader reader = new FileReader(filePath)) {

            CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.builder()
                    .setHeader(HEADERS)
                    .setSkipHeaderRecord(true)
                    .build());

            for (CSVRecord record : parser) {
                Clinic clinic = new Clinic();
                System.out.println("Prøver at få fat i enhedsnavn");
                System.out.println(record.get("Enhedsnavn"));
                clinic.setSorCode(Long.parseLong(record.get("SOR-kode")));
                clinic.setCity(record.get("P_By"));
                clinic.setCvr(Integer.parseInt(record.get("CVR")));
                clinic.setEmail(record.get("E-mail"));
                clinic.setHomepage(record.get("Hjemmeside"));
                clinic.setAddressLine(record.get("Postadresse"));
                clinic.setClinicType(record.get("Enhedstype"));
                clinic.setOrganizationName(record.get("Enhedsnavn"));
                clinic.setMainSpeciality(record.get("Hovedspeciale"));
                clinic.setPhoneNumber(record.get("Telefon"));
                clinic.setPostalCode(Integer.parseInt(record.get("P_Postnummer")));
                clinic.setRegion(record.get("P_Region"));

                clinicRepository.save(clinic);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
