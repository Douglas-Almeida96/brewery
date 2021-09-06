package com.douglas.brewery.model.lupulo.dto;

import com.douglas.brewery.model.lupulo.Lupulo;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class LupuloDto {

    private Long id;
    private String nome;
    private double quantidade;

    public LupuloDto(Lupulo lupulo) {
        this.id = lupulo.getId();
        this.nome = lupulo.getNome();
        this.quantidade = lupulo.getQuantidade();
    }


    public static List<LupuloDto> convert(List<Lupulo> lupulos) {
        List<LupuloDto> lupuloDtos = lupulos.stream().map(LupuloDto::new).collect(Collectors.toList());
        return lupuloDtos;
    }
}
