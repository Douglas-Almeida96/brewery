package com.douglas.brewery.service;

import com.douglas.brewery.model.lupulo.Lupulo;
import com.douglas.brewery.model.receita_has_lupulo.ReceitaLupulo;
import com.douglas.brewery.repository.hasReceita.ReceitaLupuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceitaLupuloService {

    private ReceitaLupuloRepository receitaLupuloRepository;

    @Autowired
    public ReceitaLupuloService(ReceitaLupuloRepository receitaLupuloRepository) {
        this.receitaLupuloRepository = receitaLupuloRepository;
    }


    public void create(ReceitaLupulo receitaLupulo) {
        receitaLupuloRepository.save(receitaLupulo);
    }
}
