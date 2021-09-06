package com.douglas.brewery.controller;

import com.douglas.brewery.model.malte.dto.MalteDto;
import com.douglas.brewery.model.malte.form.MalteForm;
import com.douglas.brewery.model.malte.Malte;
import com.douglas.brewery.service.MalteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/maltes")
public class MalteController {

    @Autowired
    MalteService malteService;

    @GetMapping
    public ResponseEntity<List<MalteDto>> getAll(){
        List<Malte> maltes = malteService.findAll();
        if(maltes==null || maltes.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(MalteDto.convert(maltes));
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<MalteDto> getById(@PathVariable("id") Long id){
        try {
            Malte malte = malteService.findById(id);
            return ResponseEntity.ok(new MalteDto(malte));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<MalteDto> create(@RequestBody @Valid MalteForm form, UriComponentsBuilder uriComponentsBuilder){
        Malte malte = form.convert();
        try {
            malteService.create(malte);
            URI uri = uriComponentsBuilder.path("maltes/{id}").buildAndExpand(malte.getId()).toUri();
            return  ResponseEntity.created(uri).body(new MalteDto(malte));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MalteDto> update(@RequestBody @Valid MalteForm form,@PathVariable("id") Long id ,
                                            UriComponentsBuilder uriComponentsBuilder){
        Malte malte = form.atulizar(id, malteService);
        try {
            malteService.alter(malte);
            URI uri = uriComponentsBuilder.path("maltes/{id}").buildAndExpand(malte.getId()).toUri();
            return  ResponseEntity.created(uri).body(new MalteDto(malte));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        try {
            malteService.delete(id);
            return  ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }


}
