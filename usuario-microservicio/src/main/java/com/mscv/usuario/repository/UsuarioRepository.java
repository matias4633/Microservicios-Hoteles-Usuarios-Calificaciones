package com.mscv.usuario.repository;

import com.mscv.usuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario,String> { //la clase y el tipo de dato de su PK
     List<Usuario> findByEmailContains(String palabraClave);
}
