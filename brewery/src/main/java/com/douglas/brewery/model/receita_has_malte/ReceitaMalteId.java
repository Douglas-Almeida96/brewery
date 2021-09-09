package com.douglas.brewery.model.receita_has_malte;

import com.douglas.brewery.model.receita.Receita;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ReceitaMalteId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long receitaId;
    private Long malteId;



    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ReceitaMalteId that = (ReceitaMalteId) o;
        return Objects.equals(receitaId, that.receitaId) && Objects.equals(malteId, that.malteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receitaId, malteId);
    }
}
