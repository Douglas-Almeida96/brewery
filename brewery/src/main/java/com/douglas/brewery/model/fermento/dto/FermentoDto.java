package com.douglas.brewery.model.fermento.dto;

import com.douglas.brewery.model.fermento.Fermento;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class FermentoDto {

    private Long id;
    private String nome;
    private int quantidade;

    public FermentoDto(Fermento fermento) {
        this.id = fermento.getId();
        this.nome = fermento.getNome();
        this.quantidade = fermento.getQuantidade();
    }

    public static List<FermentoDto> convert(List<Fermento> fermentos) {
        List<FermentoDto> fermentoDtos = fermentos.stream().map(FermentoDto::new).collect(Collectors.toList());
        return fermentoDtos;
    }
}
