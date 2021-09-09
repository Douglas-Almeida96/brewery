package com.douglas.brewery.controller;

import com.douglas.brewery.model.receita.Receita;
import com.douglas.brewery.model.receita.dto.ReceitaCompletaDto;
import com.douglas.brewery.model.receita.dto.ReceitaDto;
import com.douglas.brewery.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/Receitas")
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
        return ResponseEntity.ok(new ReceitaCompletaDto(receita));

    }

}
