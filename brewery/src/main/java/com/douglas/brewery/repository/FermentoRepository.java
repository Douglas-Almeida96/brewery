package com.douglas.brewery.repository;

import com.douglas.brewery.model.fermento.Fermento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FermentoRepository extends JpaRepository<Fermento, Long> {
}
