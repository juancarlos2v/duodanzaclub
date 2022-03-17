package com.mindhub.duodanzaclub.repositories;


import com.mindhub.duodanzaclub.models.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductoRepository extends JpaRepository<Productos, Long> {
}
