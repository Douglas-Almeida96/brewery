package com.douglas.brewery.repository.hasReceita;

import com.douglas.brewery.model.receita_has_lupulo.ReceitaLupulo;
import com.douglas.brewery.model.receita_has_lupulo.ReceitaLupuloId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReceitaLupuloRepository extends JpaRepository<ReceitaLupulo, ReceitaLupuloId>{
   @Query("select r from ReceitaLupulo r where r.receita.id = :receita_id")
    List<ReceitaLupulo> findbyReceitaId(@Param("receita_id")Long Id);
}
