package com.sda.firma;

import com.sda.fakturownia.DrukarkaFaktur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name;
    private String nip;
    private String adress;

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
    private List<DrukarkaFaktur> drukarkaFaktur;
}
