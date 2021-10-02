package com.douglas.brewery.model.receita_has_lupulo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ReceitaLupuloId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long receitaId;
    private Long lupuloId;


}
