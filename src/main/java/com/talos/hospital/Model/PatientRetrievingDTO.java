package com.talos.hospital.Model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class PatientRetrievingDTO {

    private UUID patientId;

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate admissionDate;
    private String symptomsAtAdmission;
    private EmployeeDTO doctor;




}
