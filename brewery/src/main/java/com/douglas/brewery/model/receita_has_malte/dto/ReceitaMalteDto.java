package com.douglas.brewery.model.receita_has_malte.dto;

import com.douglas.brewery.model.receita_has_malte.ReceitaMalte;
import com.douglas.brewery.model.receita_has_malte.ReceitaMalteId;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class ReceitaMalteDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nomeMalte;
    private Double quantidade;

    public ReceitaMalteDto(ReceitaMalte receitaMalte) {
        this.nomeMalte = receitaMalte.getMalte().getNome();
        this.quantidade = receitaMalte.getQuantidade();
    }
}
