package com.mscv.usuario.service;

import com.mscv.usuario.entity.Usuario;
import com.mscv.usuario.exceptions.ObjetoNoEncontrado;

import java.util.List;

public interface UsuarioService {
    Usuario saveUsuario(Usuario usuario);

    List<Usuario> getAllUsuarios();

    Usuario getUsuario(String usuarioId) throws ObjetoNoEncontrado;

    List<Usuario> getUsuariosPorPalabraContenidaEnEmail(String palabra);
}
