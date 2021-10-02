package com.douglas.brewery.controller;

import com.douglas.brewery.model.receita.Receita;
import com.douglas.brewery.model.receita.dto.ReceitaCompletaDto;
import com.douglas.brewery.model.receita.dto.ReceitaDto;
import com.douglas.brewery.model.receita.form.ReceitaForm;
import com.douglas.brewery.model.receita_has_lupulo.ReceitaLupulo;
import com.douglas.brewery.model.receita_has_lupulo.form.ReceitaLupuloForm;
import com.douglas.brewery.model.receita_has_malte.ReceitaMalte;
import com.douglas.brewery.model.receita_has_malte.form.ReceitaMalteForm;
import com.douglas.brewery.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/receitas")
public class ReceitaController {


    ReceitaService receitaService;
    FermentoService fermentoService;
    LupuloSevice lupuloSevice;
    MalteService malteService;
    ReceitaMalteService receitaMalteService;
    ReceitaLupuloService receitaLupuloService;

    @Autowired
    public ReceitaController(ReceitaService receitaService,
                             FermentoService fermentoService,
                             LupuloSevice lupuloSevice,
                             MalteService malteService,
                             ReceitaMalteService receitaMalteService,
                             ReceitaLupuloService receitaLupuloService) {
        this.receitaService = receitaService;
        this.fermentoService = fermentoService;
        this.lupuloSevice = lupuloSevice;
        this.malteService = malteService;
        this.receitaMalteService = receitaMalteService;
        this.receitaLupuloService = receitaLupuloService;
    }

    @GetMapping
    public ResponseEntity<List<ReceitaDto>> getAll(){
        List<Receita> receita = receitaService.findAll();
        return ResponseEntity.ok(ReceitaDto.convert(receita));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceitaCompletaDto> getById(@PathVariable("id") Long id){
        Receita receita = receitaService.findById(id);
        List<ReceitaLupulo> lupulos = receitaService.getLupuloReceita(id);
        List<ReceitaMalte> maltes = receitaService.getMalteReceita(id);
        return ResponseEntity.ok(new ReceitaCompletaDto(receita,lupulos,maltes));
    }

    @PostMapping
    public void save(@RequestBody @Valid ReceitaForm receitaForm){
      Receita receita = receitaService.create(receitaForm);
        Receita receitaWithMalte = receitaForm.addMalteReceita(receita, malteService, receitaMalteService);
        Receita receitaWithLupulo = receitaForm.addLupuloReceita(receitaWithMalte, lupuloSevice, receitaLupuloService);

    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        receitaService.delete(id);
        return ResponseEntity.ok().build();
    }

}
