package com.douglas.brewery.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private String nome;
    private double alfaAcido;
    private double quantidade;

    public Malte(String nome, double alfaAcido, double quantidade) {
        this.nome = nome;
        this.alfaAcido = alfaAcido;
        this.quantidade = quantidade;
    }
}
