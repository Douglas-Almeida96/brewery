package com.douglas.brewery.repository;

import com.douglas.brewery.model.malte.Malte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MalteRepository extends JpaRepository<Malte, Long> {
}
