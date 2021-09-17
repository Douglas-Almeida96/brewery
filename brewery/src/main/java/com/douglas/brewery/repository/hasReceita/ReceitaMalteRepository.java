package com.douglas.brewery.repository.hasReceita;

import com.douglas.brewery.model.receita_has_malte.ReceitaMalte;
import com.douglas.brewery.model.receita_has_malte.ReceitaMalteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceitaMalteRepository extends JpaRepository<ReceitaMalte, ReceitaMalteId> {
    @Query("select r from ReceitaMalte r where r.receita.id = :receita_id")
    List<ReceitaMalte> findbyReceitaId(@Param("receita_id")Long Id);
}
