package com.douglas.brewery.model.receita_has_malte.dto;

import com.douglas.brewery.model.receita_has_malte.ReceitaMalte;
import com.douglas.brewery.model.receita_has_malte.ReceitaMalteId;

import java.util.List;
import java.util.stream.Collectors;

public class ReceitaMalteDto {

    private ReceitaMalteId receitaMalteId;
    private String malteNome;
    private double quantidade;

    public ReceitaMalteDto(ReceitaMalte receitaMalte) {
        this.receitaMalteId = receitaMalte.getId();
        this.malteNome = receitaMalte.getMalte().getNome();
        this.quantidade = receitaMalte.getQuantidade();
    }

   /* public List<ReceitaMalteDto> convert(List<ReceitaMalte> receitaMaltes){
        List<ReceitaMalteDto> dtos = receitaMaltes.stream().map(ReceitaMalteDto::new).collect(Collectors.toList());
        return  dtos;
    }*/
}
