package com.douglas.brewery.service;

import com.douglas.brewery.model.mapper.receitahasmalte.ReceitaHasMalteMapper;
import com.douglas.brewery.model.receita.Receita;
import com.douglas.brewery.model.receita.form.ReceitaForm;
import com.douglas.brewery.model.receita_has_lupulo.ReceitaLupuloId;
import com.douglas.brewery.model.receita_has_malte.form.ReceitaMalteForm;
import com.douglas.brewery.repository.hasReceita.ReceitaMalteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaltesHasReceitaService {


    ReceitaMalteRepository receitaMalteRepository;
    MalteService malteService;

    ReceitaHasMalteMapper receitaHasMalteMapper = ReceitaHasMalteMapper.INSTANCE;

    @Autowired
    public MaltesHasReceitaService(ReceitaMalteRepository receitaMalteRepository,
                                   MalteService malteService) {
        this.receitaMalteRepository = receitaMalteRepository;
        this.malteService = malteService;
    }


    public void create(Receita receita) {
    }
}
