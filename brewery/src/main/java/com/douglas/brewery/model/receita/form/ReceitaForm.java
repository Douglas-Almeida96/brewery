package com.douglas.brewery.model.receita.form;

import com.douglas.brewery.model.receita.Receita;
import com.douglas.brewery.model.receita_has_lupulo.ReceitaLupulo;
import com.douglas.brewery.model.receita_has_lupulo.form.ReceitaLupuloForm;
import com.douglas.brewery.model.receita_has_malte.ReceitaMalte;
import com.douglas.brewery.model.receita_has_malte.form.ReceitaMalteForm;
import com.douglas.brewery.service.LupuloSevice;
import com.douglas.brewery.service.MalteService;
import com.douglas.brewery.service.ReceitaLupuloService;
import com.douglas.brewery.service.ReceitaMalteService;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class ReceitaForm {

    private String nome;
    private String estilo;
    private int ogEsperada;
    private int fgEsperada;
    private Long idFermento;

   @Valid
    @NotEmpty
    private Set<ReceitaMalteForm> receitaMalteForms = new HashSet<>();

    @Valid
    @NotEmpty
    private Set<ReceitaLupuloForm> receitaLupuloForms = new HashSet<>();

   public Receita addMalteReceita(Receita receita,
                                        MalteService malteService,
                                        ReceitaMalteService receitaMalteService){
        receita.setReceitaMaltes(this.receitaMalteForms
                .stream()
                .map(receitaMalteForms -> {
                    ReceitaMalte receitaMalte = new ReceitaMalte();
                    if(receitaMalteForms.getIdMalte() != null){
                        receitaMalte.setReceita(receita);
                        receitaMalte.setMalte(malteService.findById(receitaMalteForms.getIdMalte()));
                        receitaMalte.setQuantidade(receitaMalteForms.getQuantidade());
                    }
                    receitaMalteService.create(receitaMalte);
                    return receitaMalte;
                }).collect(Collectors.toSet()));

        return receita;
    }


    public Receita addLupuloReceita(Receita receita,
                                LupuloSevice lupuloSevice,
                                ReceitaLupuloService receitaLupuloService) {
        receita.setReceitaLupulos(this.receitaLupuloForms
                .stream()
                .map(receitaLupuloForms -> {
                    ReceitaLupulo receitaLupulo = new ReceitaLupulo();
                    if(receitaLupuloForms != null){
                        receitaLupulo.setReceita(receita);
                        receitaLupulo.setLupulo(lupuloSevice.findById(receitaLupuloForms.getIdlupulo()));
                        receitaLupulo.setQuantidade(receitaLupuloForms.getQuantidade());
                    }
                    receitaLupuloService.create(receitaLupulo);
                    return receitaLupulo;
                })
                .collect(Collectors.toSet()));
        return receita;
    }
}
