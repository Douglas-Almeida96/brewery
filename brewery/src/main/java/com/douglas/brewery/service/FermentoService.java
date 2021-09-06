package com.douglas.brewery.service;

import com.douglas.brewery.model.fermento.Fermento;
import com.douglas.brewery.repository.FermentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FermentoService {

    @Autowired
    FermentoRepository fermentoRepository;

    public List<Fermento> findAll() {
        List<Fermento> fermento = fermentoRepository.findAll();
        return fermento;
    }

    public Fermento findById(Long id) {
        Fermento fermento = fermentoRepository.findById(id).get();
        return fermento;
    }

    public void create(Fermento fermento) {
        fermentoRepository.save(fermento);
    }

    public void update(Fermento fermento) {
        fermentoRepository.save(fermento);
    }

    public void delete(Long id) {
        fermentoRepository.deleteById(id);
    }
}
