package com.talos.hospital.Model;

import com.talos.hospital.Util.LocalDateConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {


    @Id
    @Column(updatable = false, nullable = false)
    private UUID employeeId = UUID.randomUUID();

    private String firstName;
    private String lastName;
    @Convert(converter = LocalDateConverter.class)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Position position;
    private Integer age;
    private String address;
    private String phoneNumber;

    private Boolean status;


}
