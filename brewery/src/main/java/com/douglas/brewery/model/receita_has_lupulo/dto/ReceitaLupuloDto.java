package com.douglas.brewery.model.receita_has_lupulo.dto;

import com.douglas.brewery.model.receita_has_lupulo.ReceitaLupulo;
import com.douglas.brewery.model.receita_has_lupulo.ReceitaLupuloId;
import lombok.Getter;

import java.io.Serializable;


@Getter
public class ReceitaLupuloDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nomeLupulo;
    private Double quantidade;

    public ReceitaLupuloDto(ReceitaLupulo receitaLupulo){
        this.nomeLupulo = receitaLupulo.getLupulo().getNome();
        this.quantidade = receitaLupulo.getQuantidade();
    }

}
