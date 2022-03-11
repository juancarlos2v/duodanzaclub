package com.mindhub.duodanzaclub.repositories;

import com.mindhub.duodanzaclub.models.SalaFestival;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SalaFestivalRepository extends JpaRepository<SalaFestival, Long> {
}
