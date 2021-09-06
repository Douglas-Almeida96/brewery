package com.douglas.brewery.controller;

import com.douglas.brewery.model.fermento.Fermento;
import com.douglas.brewery.model.fermento.dto.FermentoDto;
import com.douglas.brewery.model.fermento.form.FermentoForm;
import com.douglas.brewery.service.FermentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/fermentos")
public class FermentoController {
    @Autowired
    FermentoService fermentoService;

    @GetMapping
    public ResponseEntity<List<FermentoDto>> getAll(){
        List<Fermento> fermentos= fermentoService.findAll();

        if(fermentos == null || fermentos.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(FermentoDto.convert(fermentos));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<FermentoDto> getById(@PathVariable("id") Long id){
        Fermento fermento = fermentoService.findById(id);
        try {
            return ResponseEntity.ok(new FermentoDto(fermento));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<FermentoDto> create(@RequestBody @Valid FermentoForm form,
    UriComponentsBuilder uriComponentsBuilder){
        try {
            Fermento fermento = form.convert();
            fermentoService.create(fermento);
            URI uri = uriComponentsBuilder.path("fermentos/{id}").buildAndExpand(fermento.getId()).toUri();
            return ResponseEntity.created(uri).body(new FermentoDto(fermento));
        }catch (Exception e){
            return  ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<FermentoDto> update(@RequestBody @Valid FermentoForm form, @PathVariable("id") Long id,
    UriComponentsBuilder uriComponentsBuilder){
        try {
            Fermento fermento = form.atualizar(id, fermentoService);
            fermentoService.update(fermento);
            URI uri = uriComponentsBuilder.path("fermentos/{id}").buildAndExpand(fermento.getId()).toUri();
            return ResponseEntity.created(uri).body(new FermentoDto(fermento));
        }catch (Exception e){
            return  ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<FermentoDto> delete(@PathVariable("id") Long id){
        try {
            fermentoService.delete(id);
            return  ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

}
