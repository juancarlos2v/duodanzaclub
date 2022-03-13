package com.mindhub.duodanzaclub.repositories;

import com.mindhub.duodanzaclub.models.Academia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AcademiaRepository extends JpaRepository<Academia, Long>{
    Academia findByNombre(String nombre);
}
