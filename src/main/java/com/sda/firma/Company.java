package com.sda.firma;

import com.sda.fakturownia.BaseEntity;
import com.sda.fakturownia.DrukarkaFaktur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"drukarkaFaktur", "platnik"})
public class Company extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name;
    private String nip;
    private String adress;

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
    private List<DrukarkaFaktur> drukarkaFaktur;

    @ManyToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<Platnik> platnik;
}
