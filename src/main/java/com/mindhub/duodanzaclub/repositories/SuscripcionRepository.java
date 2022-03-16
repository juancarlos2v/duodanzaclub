package com.mindhub.duodanzaclub.repositories;


import com.mindhub.duodanzaclub.models.Suscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SuscripcionRepository extends JpaRepository<Suscripcion, Long> {
}
