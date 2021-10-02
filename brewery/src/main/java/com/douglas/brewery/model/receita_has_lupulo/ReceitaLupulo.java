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


}
