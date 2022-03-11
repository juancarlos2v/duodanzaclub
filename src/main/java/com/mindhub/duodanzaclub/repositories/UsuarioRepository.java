package com.mindhub.duodanzaclub.repositories;

import com.mindhub.duodanzaclub.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByEmail(@Param("email") String email);
}
