package com.douglas.brewery.model.malte;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


import com.douglas.brewery.model.receita_has_malte.ReceitaMalte;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Malte {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;
    private double ebc;
    private double quantidade;

    @OneToMany(mappedBy = "malte")
    private Set<ReceitaMalte> receitaMaltes = new HashSet<>();

    public Malte(String nome, double ebc, double quantidade) {
        this.nome = nome;
        this.ebc = ebc;
        this.quantidade = quantidade;
    }
}
