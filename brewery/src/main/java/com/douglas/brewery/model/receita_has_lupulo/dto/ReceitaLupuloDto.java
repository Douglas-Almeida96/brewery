package com.douglas.brewery.model.receita_has_lupulo.dto;

import com.douglas.brewery.model.receita_has_lupulo.ReceitaLupulo;
import com.douglas.brewery.model.receita_has_lupulo.ReceitaLupuloId;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ReceitaLupuloDto {


    private ReceitaLupuloId receitaLupuloId;
    private String nomeLupulo;
    private Double quantidade;

    public ReceitaLupuloDto(ReceitaLupulo receitaLupulo){
        this.receitaLupuloId = receitaLupulo.getId();
        this.nomeLupulo = receitaLupulo.getLupulo().getNome();
        this.quantidade = receitaLupulo.getQuantidade();
    }

  /*  public List<ReceitaLupuloDto> convert(List<ReceitaLupulo> receitaLupulos){
        List<ReceitaLupuloDto> dtos = receitaLupulos.stream().map(ReceitaLupuloDto::new).collect(Collectors.toList());
        return dtos;
    }*/

}
