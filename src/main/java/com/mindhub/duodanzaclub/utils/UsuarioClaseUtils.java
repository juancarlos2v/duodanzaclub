package com.mindhub.duodanzaclub.utils;

import com.mindhub.duodanzaclub.models.Clase;
import com.mindhub.duodanzaclub.models.Usuario;
import com.mindhub.duodanzaclub.models.UsuarioClase;

import java.util.List;

public final class UsuarioClaseUtils {

    private UsuarioClaseUtils(){}

    public static UsuarioClase buscarAnotadoClases(Usuario usuario, Clase clase, List<UsuarioClase> usuarioClases){
        Boolean encontrado = false;
        int i = 0;
        UsuarioClase usuarioClase = null;

        do{
            usuarioClase = usuarioClases.get(i);
            if((usuarioClase.getUsuario() == usuario) && (usuarioClase.getClase() == clase)){
                encontrado = true;
                return usuarioClase;
            }
            i++;
        }
        while(encontrado == false && i < usuarioClases.size());

        if(encontrado == false){
            usuarioClase = null;
        }
        return usuarioClase;
    }
}
