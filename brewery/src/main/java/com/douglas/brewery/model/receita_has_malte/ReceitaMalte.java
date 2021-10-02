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


}
