package com.douglas.brewery.model.lupulo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Lupulo {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private double alfaacido;
    private double quantidade;

    public Lupulo(String nome, double alfaacido, double quantidade) {
        this.nome = nome;
        this.alfaacido = alfaacido;
        this.quantidade = quantidade;
    }
}
