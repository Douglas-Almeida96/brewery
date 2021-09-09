package com.douglas.brewery.service;

import com.douglas.brewery.model.receita.Receita;
import com.douglas.brewery.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceitaService {

    @Autowired
    ReceitaRepository receitaRepository;

    public List<Receita> findAll() {
        List<Receita> receita = receitaRepository.findAll();
        return  receita;
    }

    public Receita getById(Long id) {
        Receita receita = receitaRepository.findById(id).get();
        return  receita;
    }
}
