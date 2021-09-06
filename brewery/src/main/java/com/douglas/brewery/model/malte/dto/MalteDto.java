package com.douglas.brewery.model.malte.dto;

import com.douglas.brewery.model.malte.Malte;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class MalteDto {

    private Long id;
    private String nome;
    private double quantidade;


    public MalteDto(Malte malte) {
        this.id = malte.getId();
        this.nome = malte.getNome();
        this.quantidade = malte.getQuantidade();
    }

    public static List<MalteDto> convert(List<Malte> maltes) {
            List<MalteDto> dtos = maltes.stream().map(MalteDto::new).collect(Collectors.toList());
            return dtos;
        }
}
