package com.mindhub.duodanzaclub.utils;

import com.mindhub.duodanzaclub.models.Usuario;

import java.util.List;

public final class UsuarioUtils {

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
}
