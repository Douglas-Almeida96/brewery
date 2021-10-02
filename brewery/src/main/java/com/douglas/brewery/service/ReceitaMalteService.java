package com.douglas.brewery.service;

import com.douglas.brewery.model.receita_has_malte.ReceitaMalte;
import com.douglas.brewery.repository.ReceitaRepository;
import com.douglas.brewery.repository.hasReceita.ReceitaMalteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceitaMalteService {


    ReceitaMalteRepository receitaMalteRepository;


    @Autowired
    public ReceitaMalteService(ReceitaMalteRepository receitaMalteRepository) {
        this.receitaMalteRepository = receitaMalteRepository;
    }


    public void create(ReceitaMalte receitaMalte) {
        receitaMalteRepository.save(receitaMalte);
    }
}
