package com.mindhub.duodanzaclub.repositories;

import com.mindhub.duodanzaclub.models.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClaseRepository extends JpaRepository<Clase, Long> {

}
