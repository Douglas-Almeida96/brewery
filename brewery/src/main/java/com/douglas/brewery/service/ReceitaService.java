package com.douglas.brewery.service;

import com.douglas.brewery.model.fermento.Fermento;
import com.douglas.brewery.model.receita.Receita;
import com.douglas.brewery.model.receita_has_lupulo.ReceitaLupulo;
import com.douglas.brewery.model.receita_has_malte.ReceitaMalte;
import com.douglas.brewery.repository.FermentoRepository;
import com.douglas.brewery.repository.ReceitaRepository;
import com.douglas.brewery.repository.hasReceita.ReceitaLupuloRepository;
import com.douglas.brewery.repository.hasReceita.ReceitaMalteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceitaService {

    @Autowired
    ReceitaRepository receitaRepository;

    @Autowired
    ReceitaLupuloRepository receitaLupuloRepository;

    @Autowired
    ReceitaMalteRepository receitaMalteRepository;

    @Autowired
    FermentoRepository fermentoRepository;

    public List<Receita> findAll() {
        List<Receita> receita = receitaRepository.findAll();
        return  receita;
    }

    public Receita getById(Long id) {
        Receita receita = receitaRepository.findById(id).get();
        return  receita;
    }

   public List<ReceitaLupulo> getLupuloReceita(Long id) {
        List<ReceitaLupulo> lupulos = receitaLupuloRepository.findbyReceitaId(id);
        return lupulos;
    }

     public List<ReceitaMalte> getMalteReceita(Long id){
        List<ReceitaMalte> maltes = receitaMalteRepository.findbyReceitaId(id);
        return maltes;
    }

  /*  public Fermento getFermentoReceita(Long id){
        Fermento fermento = fermentoRepository.findById(id).get();
        return fermento;
    }*/


}
