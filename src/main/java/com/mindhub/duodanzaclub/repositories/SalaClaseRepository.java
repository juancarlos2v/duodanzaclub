package com.mindhub.duodanzaclub.repositories;

import com.mindhub.duodanzaclub.models.SalaClase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SalaClaseRepository extends JpaRepository<SalaClase, Long> {
}
