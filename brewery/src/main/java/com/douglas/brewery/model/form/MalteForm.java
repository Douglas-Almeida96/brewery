package com.douglas.brewery.model.form;

import com.douglas.brewery.model.Malte;
import com.douglas.brewery.service.MalteService;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class MalteForm {

    private String nome;
    private double ebc;
    private double quantidade;



    public Malte convert() {
        Malte malte = new Malte(this.nome, this.ebc, this.quantidade);
        return  malte;
    }

    public Malte atulizar(Long id, MalteService service) {
        Malte malte = service.findById(id);

        malte.setNome(this.nome);
        malte.setEbc(this.ebc);
        malte.setQuantidade(this.quantidade);

        return malte;
    }
}
