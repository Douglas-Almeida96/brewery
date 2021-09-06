package com.douglas.brewery.service;

import com.douglas.brewery.model.malte.Malte;
import com.douglas.brewery.repository.MalteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MalteService {
    @Autowired
    MalteRepository malteRepository;


    public List<Malte> findAll() {
            List<Malte> malte = malteRepository.findAll();
            return malte;
    }

    public Malte findById(Long id) {
        Malte malte = malteRepository.findById(id).get();
        return malte;
    }

    public void create(Malte malte) {
        malteRepository.save(malte);
    }


    public void alter(Malte malte) {
        malteRepository.save(malte);
    }

    public void delete(Long id) {
        malteRepository.deleteById(id);
    }
}
