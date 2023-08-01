package com.mscv.usuario.controllers;

import com.mscv.usuario.entity.Usuario;
import com.mscv.usuario.exceptions.ObjetoNoEncontrado;
import com.mscv.usuario.service.UsuarioService;
import com.mscv.usuario.service.implementaciones.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioServiceImpl servicio;
    @PostMapping
    public ResponseEntity<Usuario> guardarUsuario (@RequestBody Usuario usuarioRecibido){
        Usuario usuario = servicio.saveUsuario(usuarioRecibido);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuario> buscarUsuario (@PathVariable String idUsuario) throws ObjetoNoEncontrado {
        Usuario usuario = servicio.getUsuario(idUsuario);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/feign/{idUsuario}")
    public ResponseEntity<Usuario> buscarUsuarioFeign (@PathVariable String idUsuario) throws ObjetoNoEncontrado {
        Usuario usuario = servicio.getUsuarioFeing(idUsuario);
        return ResponseEntity.ok(usuario);
    }
    @GetMapping("/feign/listar")
    public ResponseEntity<List<Usuario>> listarUsuariosFeign(){
        List<Usuario> usuarios = servicio.getAllUsuariosFeing();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        List<Usuario> usuarios = servicio.getAllUsuarios();
        return ResponseEntity.ok(usuarios);
    }
    @GetMapping("/email")
    public ResponseEntity<List<Usuario>> buscarPorEmail(@RequestParam String palabra){ //Busca el parametro palabra=dato en la url
        List<Usuario> usuarios = servicio.getUsuariosPorPalabraContenidaEnEmail(palabra);
        return ResponseEntity.ok(usuarios);
    }
}
