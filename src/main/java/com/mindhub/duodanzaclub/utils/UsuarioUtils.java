package com.mindhub.duodanzaclub.utils;

import com.mindhub.duodanzaclub.models.Usuario;
import com.mindhub.duodanzaclub.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public final class UsuarioUtils {

    @Autowired
    UsuarioService usuarioService;

    private UsuarioUtils(){}

    public static Boolean buscarEntreContactos(Usuario usuario2, List<Usuario> usuarios){
        Boolean sonContactos = false;
        int i = 0;

        do {
            Usuario usuario = usuarios.get(i);

            if(usuario == usuario2){
                sonContactos = true;
            }
            i++;

        }
        while (sonContactos == false && i < usuarios.size());

        return sonContactos;
    }

    public static Boolean buscarEntreContactosPorID(Long usuario2, List<Long> usuarios){
        Boolean sonContactos = false;
        int i = 0;

        do {
            Long usuario = usuarios.get(i);

            if(usuario == usuario2){
                sonContactos = true;
            }
            i++;

        }
        while (sonContactos == false && i < usuarios.size());

        return sonContactos;
    }

    public static void actualizarFollow(Usuario usuario1, Usuario usuario2) {
        usuario1.getFollowing().add(usuario2);
        usuario2.getFollowers().add(usuario1);
        if(usuario1.getFollowing().contains(usuario2) && usuario1.getFollowers().contains(usuario2)){
            usuario1.getContactos().add(usuario2.getId());
            usuario2.getContactos().add(usuario1.getId());
        }
    }
}
