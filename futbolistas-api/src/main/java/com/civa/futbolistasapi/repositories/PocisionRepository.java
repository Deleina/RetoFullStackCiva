package com.civa.futbolistasapi.repositories;

import com.civa.futbolistasapi.entities.Posicion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PocisionRepository extends JpaRepository<Posicion, Long> {
}
