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

    @OneToMany(mappedBy = "lupulo")
    private Set<ReceitaLupulo> receitaLupulos = new HashSet<>();

    @OneToMany(mappedBy = "malte")
    private Set<ReceitaMalte> receitaMaltes = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receita receita = (Receita) o;

        if (ogEsperada != receita.ogEsperada)
            return false;
        if (fgEsperada != receita.fgEsperada)
            return false;
        if (!Objects.equals(id, receita.id))
            return false;
        if (!Objects.equals(nome, receita.nome))
            return false;
        if (!Objects.equals(estilo, receita.estilo))
            return false;
        if (!Objects.equals(fermento, receita.fermento))
            return false;
        if (!Objects.equals(receitaLupulos, receita.receitaLupulos))
            return false;

        return Objects.equals(receitaMaltes, receita.receitaMaltes);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (estilo != null ? estilo.hashCode() : 0);
        result = 31 * result + ogEsperada;
        result = 31 * result + fgEsperada;
        result = 31 * result + (fermento != null ? fermento.hashCode() : 0);
        result = 31 * result + (receitaLupulos != null ? receitaLupulos.hashCode() : 0);
        result = 31 * result + (receitaMaltes != null ? receitaMaltes.hashCode() : 0);
        return result;
    }
}
