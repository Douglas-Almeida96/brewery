package com.douglas.brewery.service;

import com.douglas.brewery.model.lupulo.Lupulo;
import com.douglas.brewery.repository.LupuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LupuloSevice {

    @Autowired
    LupuloRepository lupuloRepository;

    public Lupulo findById(Long id) {
        return lupuloRepository.findById(id).get();
    }


    public List<Lupulo> findAll() {
        List<Lupulo> lupulo = lupuloRepository.findAll();
        return lupulo;
    }

    public void create(Lupulo lupulo) {
        lupuloRepository.save(lupulo);
    }

    public void update(Lupulo lupulo) {
        lupuloRepository.save(lupulo);
    }

    public void delete(Long id) {
        lupuloRepository.deleteById(id);
    }
}
