package com.sda.firma;

import com.sda.fakturownia.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Platnik extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name;
    private String surname;
    private String nipPlatnika;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Company> company;
}
