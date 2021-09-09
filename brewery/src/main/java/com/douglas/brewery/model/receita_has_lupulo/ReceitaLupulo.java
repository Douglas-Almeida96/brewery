package com.douglas.brewery.model.receita_has_lupulo;

import com.douglas.brewery.model.lupulo.Lupulo;
import com.douglas.brewery.model.receita.Receita;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ReceitaLupulo {

    @EmbeddedId
    private  ReceitaLupuloId id = new ReceitaLupuloId();

    @ManyToOne
    @MapsId("receitaId")
    private Receita receita;

    @ManyToOne
    @MapsId("lupuloId")
    private Lupulo lupulo;

    private Double quantidade;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ReceitaLupulo that = (ReceitaLupulo) o;

        if (!Objects.equals(id, that.id))
            return false;
        if (!Objects.equals(receita, that.receita))
            return false;
        if (!Objects.equals(lupulo, that.lupulo))
            return false;

        return Objects.equals(quantidade, that.quantidade);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (receita != null ? receita.hashCode() : 0);
        result = 31 * result + (lupulo != null ? lupulo.hashCode() : 0);
        result = 31 * result + (quantidade != null ? quantidade.hashCode() : 0);
        return result;
    }
}
