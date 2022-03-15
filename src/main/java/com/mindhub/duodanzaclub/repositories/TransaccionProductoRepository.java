package com.mindhub.duodanzaclub.repositories;

import com.mindhub.duodanzaclub.models.TransaccionProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TransaccionProductoRepository extends JpaRepository<TransaccionProducto, Long> {
}
