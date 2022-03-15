package com.mindhub.duodanzaclub.repositories;


import com.mindhub.duodanzaclub.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
