package com.douglas.brewery.model.fermento.form;


import com.douglas.brewery.model.fermento.Fermento;
import com.douglas.brewery.service.FermentoService;
import lombok.Setter;

@Setter
public class FermentoForm {

    private Long id;
    private String nome;
    private int quantidade;


    public Fermento convert() {
        Fermento fermento = new Fermento(this.nome, this.quantidade);
        return fermento;
    }

    public Fermento atualizar(Long id, FermentoService fermentoService) {
        Fermento fermento = fermentoService.findById(id);

        fermento.setNome(this.nome);
        fermento.setQuantidade(this.quantidade);

        return fermento;
    }
}
