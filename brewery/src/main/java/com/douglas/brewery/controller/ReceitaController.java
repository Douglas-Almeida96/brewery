package com.douglas.brewery.controller;

import com.douglas.brewery.model.fermento.Fermento;
import com.douglas.brewery.model.lupulo.Lupulo;
import com.douglas.brewery.model.malte.Malte;
import com.douglas.brewery.model.receita.Receita;
import com.douglas.brewery.model.receita.dto.ReceitaCompletaDto;
import com.douglas.brewery.model.receita.dto.ReceitaDto;
import com.douglas.brewery.model.receita_has_lupulo.ReceitaLupulo;
import com.douglas.brewery.model.receita_has_malte.ReceitaMalte;
import com.douglas.brewery.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/receitas")
public class ReceitaController {

    @Autowired
    ReceitaService receitaService;

    @GetMapping
    public ResponseEntity<List<ReceitaDto>> getAll(){
        List<Receita> receita = receitaService.findAll();
        return ResponseEntity.ok(ReceitaDto.convert(receita));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceitaCompletaDto> getById(@PathVariable("id") Long id){
        Receita receita = receitaService.getById(id);
        List<ReceitaLupulo> lupulos = receitaService.getLupuloReceita(id);
        List<ReceitaMalte> maltes = receitaService.getMalteReceita(id);
        /*Fermento fermento = receitaService.getFermentoReceita(id);*/
        return ResponseEntity.ok(new ReceitaCompletaDto(receita,lupulos,maltes))/*,fermento*/;
    }
        /**/



}
