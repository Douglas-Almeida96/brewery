package com.douglas.brewery.service;

import com.douglas.brewery.model.mapper.ReceitaMapper;
import com.douglas.brewery.model.receita.Receita;
import com.douglas.brewery.model.receita.form.ReceitaForm;
import com.douglas.brewery.model.receita_has_lupulo.ReceitaLupulo;
import com.douglas.brewery.model.receita_has_malte.ReceitaMalte;
import com.douglas.brewery.repository.ReceitaRepository;
import com.douglas.brewery.repository.hasReceita.ReceitaLupuloRepository;
import com.douglas.brewery.repository.hasReceita.ReceitaMalteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceitaService {

    ReceitaRepository receitaRepository;
    ReceitaLupuloRepository receitaLupuloRepository;
    ReceitaMalteRepository receitaMalteRepository;
    FermentoService fermentoService;

    private final ReceitaMapper receitaMapper = ReceitaMapper.INSTANCE;

    @Autowired
    public ReceitaService(ReceitaRepository receitaRepository,
                          ReceitaLupuloRepository receitaLupuloRepository,
                          ReceitaMalteRepository receitaMalteRepository,
                          FermentoService fermentoService) {
        this.receitaRepository = receitaRepository;
        this.receitaLupuloRepository = receitaLupuloRepository;
        this.receitaMalteRepository = receitaMalteRepository;
        this.fermentoService = fermentoService;
    }

    public List<Receita> findAll() {
        List<Receita> receita = receitaRepository.findAll();
        return  receita;
    }

    public Receita findById(Long id) {
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

    public Receita create(ReceitaForm receitaForm) {
        ReceitaMalte receitaMalte = new ReceitaMalte();
        Receita receita = receitaMapper.dtoToModel(receitaForm);
        receita.setFermento(fermentoService.findById(receitaForm.getIdFermento()));
        Receita saveReceita = receitaRepository.save(receita);
        return  saveReceita;
    }

    public void delete(Long id) {
        List<ReceitaMalte> maltes = getMalteReceita(id);
        receitaMalteRepository.deleteAll(maltes);
        List<ReceitaLupulo> lupulos = getLupuloReceita(id);
        receitaLupuloRepository.deleteAll(lupulos);
        receitaRepository.deleteById(id);

    }


}
