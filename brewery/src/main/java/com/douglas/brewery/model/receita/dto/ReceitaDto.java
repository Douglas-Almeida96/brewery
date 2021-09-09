package com.douglas.brewery.model.receita.dto;

import com.douglas.brewery.model.receita.Receita;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ReceitaDto {

    private Long id;
    private String nome;
    private String estilo;

    public ReceitaDto(Receita receita) {
        this.id = receita.getId();
        this.nome = receita.getNome();
        this.estilo = receita.getEstilo();
    }

    public static List<ReceitaDto> convert(List<Receita> receitas) {
        List<ReceitaDto> receitaDtos = receitas.stream().map(ReceitaDto::new).collect(Collectors.toList());
        return null;
    }
}
