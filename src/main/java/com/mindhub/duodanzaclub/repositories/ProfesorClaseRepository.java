package com.mindhub.duodanzaclub.repositories;

import com.mindhub.duodanzaclub.models.ProfesorClase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProfesorClaseRepository extends JpaRepository<ProfesorClase, Long> {
}
