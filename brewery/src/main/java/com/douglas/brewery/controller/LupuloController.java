package com.douglas.brewery.controller;

import com.douglas.brewery.model.lupulo.Lupulo;
import com.douglas.brewery.model.lupulo.dto.LupuloDto;
import com.douglas.brewery.model.lupulo.form.LupuloForm;
import com.douglas.brewery.service.LupuloSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/lupulos")
public class LupuloController {

    @Autowired
    LupuloSevice lupuloSevice;

    @GetMapping
    public ResponseEntity<List<LupuloDto>> getAll(){
        List<Lupulo> lupulos = lupuloSevice.findAll();

        if(lupulos == null || lupulos.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(LupuloDto.convert(lupulos));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<LupuloDto> getById(@PathVariable("id") Long id){
        Lupulo lupulo = lupuloSevice.findById(id);
        try {
            return ResponseEntity.ok(new LupuloDto(lupulo));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<LupuloDto> create(@RequestBody @Valid LupuloForm form,
    UriComponentsBuilder uriComponentsBuilder){
        try {
            Lupulo lupulo = form.convert();
            lupuloSevice.create(lupulo);
            URI uri = uriComponentsBuilder.path("lupulos/{id}").buildAndExpand(lupulo.getId()).toUri();
            return ResponseEntity.created(uri).body(new LupuloDto(lupulo));
        }catch (Exception e){
            return  ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<LupuloDto> update(@RequestBody @Valid LupuloForm form, @PathVariable("id") Long id,
    UriComponentsBuilder uriComponentsBuilder){
        try {
            Lupulo lupulo = form.atualizar(id, lupuloSevice);
            lupuloSevice.update(lupulo);
            URI uri = uriComponentsBuilder.path("lupulos/{id}").buildAndExpand(lupulo.getId()).toUri();
            return ResponseEntity.created(uri).body(new LupuloDto(lupulo));
        }catch (Exception e){
            return  ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<LupuloDto> delete(@PathVariable("id") Long id){
        try {
            lupuloSevice.delete(id);
            return  ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
