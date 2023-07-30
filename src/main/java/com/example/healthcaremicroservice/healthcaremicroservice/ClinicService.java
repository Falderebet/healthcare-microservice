package com.example.healthcaremicroservice.healthcaremicroservice;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

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



        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
