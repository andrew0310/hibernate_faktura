package com.sda.fakturownia;

import com.sda.firma.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class DrukarkaFaktur extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name;
    private LocalDate date;
    private LocalDate terminPlatnosci;

    @Column(nullable = false)
    private Double kwota;

    private String nipFirmy;
    private String nipPlatnika;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;
}
