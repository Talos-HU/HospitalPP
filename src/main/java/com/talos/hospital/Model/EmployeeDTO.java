package com.talos.hospital.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private String firstName;
    private String lastName;
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Position position;

}
