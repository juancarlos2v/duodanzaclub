package com.mindhub.duodanzaclub.repositories;

import com.mindhub.duodanzaclub.models.Festival;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FestivalRepository extends JpaRepository<Festival, Long> {
}
