package com.douglas.brewery.model.receita.dto;



import com.douglas.brewery.model.fermento.Fermento;
import com.douglas.brewery.model.receita.Receita;
import com.douglas.brewery.model.receita_has_lupulo.ReceitaLupulo;
import com.douglas.brewery.model.receita_has_lupulo.dto.ReceitaLupuloDto;
import com.douglas.brewery.model.receita_has_malte.ReceitaMalte;
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
    private String nomeFermento;
    public List<ReceitaMalteDto> receitaMaltes;
    public List<ReceitaLupuloDto> receitaLupulos;

    public ReceitaCompletaDto(Receita receita, List<ReceitaLupulo> lupulos,
                              List<ReceitaMalte> maltes /*, Fermento fermento*/){
        this.id = receita.getId();
        this.nome = receita.getNome();
        this.estilo = receita.getEstilo();
        this.ogEsperada = receita.getOgEsperada();
        this.fgEsperada = receita.getFgEsperada();
        this.nomeFermento = receita.getFermento().getNome();

        this.receitaLupulos = new ArrayList<>();
        this.receitaLupulos.addAll(lupulos
                .stream().map(ReceitaLupuloDto::new).collect(Collectors.toList()));

        this.receitaMaltes = new ArrayList<>();
        this.receitaMaltes.addAll(maltes
                .stream().map(ReceitaMalteDto::new).collect(Collectors.toList()));
    }

}
