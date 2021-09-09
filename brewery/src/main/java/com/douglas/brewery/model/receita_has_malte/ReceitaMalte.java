package com.douglas.brewery.model.receita_has_malte;

import com.douglas.brewery.model.malte.Malte;
import com.douglas.brewery.model.receita.Receita;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ReceitaMalte {

    @EmbeddedId
    private ReceitaMalteId id = new ReceitaMalteId();

    @ManyToOne
    @MapsId("receitaId")
    private Receita receita;

    @ManyToOne
    @MapsId("malteId")
    private Malte malte;

    private Double quantidade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReceitaMalte that = (ReceitaMalte) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(receita, that.receita)) return false;
        if (!Objects.equals(malte, that.malte)) return false;
        return Objects.equals(quantidade, that.quantidade);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (receita != null ? receita.hashCode() : 0);
        result = 31 * result + (malte != null ? malte.hashCode() : 0);
        result = 31 * result + (quantidade != null ? quantidade.hashCode() : 0);
        return result;
    }
}
