package com.civa.futbolistasapi.repositories;

import com.civa.futbolistasapi.entities.Futbolista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FutbolistaRepository extends JpaRepository<Futbolista, Long> {
}
