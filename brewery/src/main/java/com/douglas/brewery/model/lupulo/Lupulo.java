package com.douglas.brewery.model.lupulo;

import com.douglas.brewery.model.receita_has_lupulo.ReceitaLupulo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "lupulo")
    private Set<ReceitaLupulo> receitaLupulos = new HashSet<>();

    public Lupulo(String nome, double alfaacido, double quantidade) {
        this.nome = nome;
        this.alfaacido = alfaacido;
        this.quantidade = quantidade;
    }
}
