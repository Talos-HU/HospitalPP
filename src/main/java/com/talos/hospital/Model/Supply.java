package com.talos.hospital.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Supply {

    @Id
    @GeneratedValue
    private UUID supplyId;

    private String name;
    @Enumerated(EnumType.STRING)
    private Pretence pretence;
    private int amountOnStorage;
    private int priceWithoutCoverage;
    private int priceWithCoverage;
}
