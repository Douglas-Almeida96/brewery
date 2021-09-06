package com.douglas.brewery.model.lupulo.form;

import com.douglas.brewery.model.lupulo.Lupulo;
import com.douglas.brewery.service.LupuloSevice;
import lombok.Setter;

@Setter
public class LupuloForm {

    private String nome;
    private double alfaacido;
    private double quantidade;


    public Lupulo convert() {
        Lupulo lupulo = new Lupulo(this.nome, this.alfaacido, this.quantidade);
        return  lupulo;
    }

    public Lupulo atualizar(Long id, LupuloSevice lupuloSevice) {
        Lupulo lupulo = lupuloSevice.findById(id);

        lupulo.setNome(this.nome);
        lupulo.setAlfaacido(this.alfaacido);
        lupulo.setQuantidade(this.quantidade);

        return lupulo;
    }
}
