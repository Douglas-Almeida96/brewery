package com.douglas.brewery.model.form;

import com.douglas.brewery.model.Malte;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class MalteForm {

    private String nome;
    private double alfaAcido;
    private double quantidade;



    public Malte convert() {
        Malte malte = new Malte(this.nome, this.alfaAcido, this.quantidade);
        return  malte;
    }
}
