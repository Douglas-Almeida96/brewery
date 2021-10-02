package com.douglas.brewery.model.receita;

import com.douglas.brewery.model.fermento.Fermento;
import com.douglas.brewery.model.receita_has_lupulo.ReceitaLupulo;
import com.douglas.brewery.model.receita_has_malte.ReceitaMalte;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Receita {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String estilo;
    private int ogEsperada;
    private int fgEsperada;


    @ManyToOne
    private Fermento fermento;

    @OneToMany(mappedBy = "lupulo", fetch = FetchType.LAZY)
    private Set<ReceitaLupulo> receitaLupulos = new HashSet<>();

    @OneToMany(mappedBy = "malte", fetch = FetchType.LAZY)
    private Set<ReceitaMalte> receitaMaltes = new HashSet<>();

    public Receita(String nome, String estilo, int ogEsperada, int fgEsperada, Fermento fermento) {
        this.nome = nome;
        this.estilo = estilo;
        this.ogEsperada = ogEsperada;
        this.fgEsperada = fgEsperada;
        this.fermento = fermento;
    }

}
