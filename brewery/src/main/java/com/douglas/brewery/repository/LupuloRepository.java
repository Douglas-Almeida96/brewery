package com.douglas.brewery.repository;

import com.douglas.brewery.model.lupulo.Lupulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LupuloRepository extends JpaRepository<Lupulo, Long> {
}
