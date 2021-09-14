package com.douglas.brewery.model.receita.dto;



import com.douglas.brewery.model.receita.Receita;
import com.douglas.brewery.model.receita_has_lupulo.dto.ReceitaLupuloDto;
import com.douglas.brewery.model.receita_has_malte.dto.ReceitaMalteDto;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ReceitaCompletaDto {

    private Long id;
    private String nome;
    private String estilo;
    private int ogEsperada;
    private int fgEsperada;
    private List<ReceitaMalteDto> receitaMaltes;
    private List<ReceitaLupuloDto> receitaLupulos;

    public ReceitaCompletaDto(Receita receita){
        this.id = receita.getId();
        this.nome = receita.getNome();
        this.estilo = receita.getEstilo();
        this.ogEsperada = receita.getOgEsperada();
        this.fgEsperada = receita.getFgEsperada();

        this.receitaLupulos = new ArrayList<>();
        this.receitaLupulos.addAll(receita.getReceitaLupulos()
                        .stream().map(ReceitaLupuloDto::new).collect(Collectors.toList()));

        this.receitaMaltes = new ArrayList<>();
        this.receitaMaltes.addAll(receita.getReceitaMaltes()
                .stream().map(ReceitaMalteDto::new).collect(Collectors.toList()));
    }

}
