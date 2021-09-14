package com.douglas.brewery.repository.hasReceita;


import com.douglas.brewery.model.receita_has_malte.ReceitaMalte;
import com.douglas.brewery.model.receita_has_malte.ReceitaMalteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaMalteRepository extends JpaRepository<ReceitaMalte, ReceitaMalteId> {
}
