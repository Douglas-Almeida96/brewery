package com.douglas.brewery.repository.hasReceita;

import com.douglas.brewery.model.receita_has_lupulo.ReceitaLupulo;
import com.douglas.brewery.model.receita_has_lupulo.ReceitaLupuloId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReceitaLupuloRepository extends JpaRepository<ReceitaLupulo, ReceitaLupuloId>{
}
