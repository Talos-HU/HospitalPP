package com.talos.hospital.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {

    @Id
    @GeneratedValue
    private UUID patientId = UUID.randomUUID();

    private String firstName;
    private String lastName;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate admissionDate;
    private String symptomsAtAdmission;
    @OneToOne
    @JsonIgnore
    private Employee doctor;

    @OneToMany
    @Enumerated(EnumType.STRING)
    private List<Supply> listOfSupplyIds;


}
