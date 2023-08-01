package com.mscv.usuario.service.implementaciones;

import com.mscv.usuario.entity.Calificacion;
import com.mscv.usuario.entity.Hotel;
import com.mscv.usuario.entity.Usuario;
import com.mscv.usuario.exceptions.ObjetoNoEncontrado;
import com.mscv.usuario.externo.servicio.CalificacionServicio;
import com.mscv.usuario.externo.servicio.HotelServicio;
import com.mscv.usuario.repository.UsuarioRepository;
import com.mscv.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository repositorio;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelServicio hotelServicio;

    @Autowired
    private CalificacionServicio calificacionServicio;

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        String randomId= UUID.randomUUID().toString(); //Le pongo un id ramdom
        usuario.setUsuarioId(randomId);
        return repositorio.save(usuario);
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return  completarUsuario(repositorio.findAll());
    }

    public List<Usuario> getAllUsuariosFeing() {
        return  completarUsuarioFeign(repositorio.findAll());
    }

    @Override
    public Usuario getUsuario(String usuarioId) throws ObjetoNoEncontrado { //de esta forma comunico los microservicios.
        Usuario usuario = repositorio.findById(usuarioId).orElseThrow( ()-> new ObjetoNoEncontrado(String.format("El objeto con id %s no existe", usuarioId)));
        return completarUsuario(usuario);
    }


    public Usuario getUsuarioFeing(String usuarioId) throws ObjetoNoEncontrado { //de esta forma comunico los microservicios.
        Usuario usuario = repositorio.findById(usuarioId).orElseThrow( ()-> new ObjetoNoEncontrado(String.format("El objeto con id %s no existe", usuarioId)));
        return completarUsuarioFeign(usuario);
    }

    @Override
    public List<Usuario> getUsuariosPorPalabraContenidaEnEmail(String palabra) {
       return repositorio.findByEmailContains(palabra);
    }

    public Usuario completarUsuario(Usuario usuario){
        Calificacion[] calificaciones = restTemplate.getForObject("http://CALIFICACION-SERVICIO/calificaciones/usuarios/"+usuario.getUsuarioId(), Calificacion[].class);
        for (Calificacion c:calificaciones) {
            ResponseEntity<Hotel> h = restTemplate.getForEntity("http://HOTEL-SERVICIO/hoteles/"+c.getHotelId(), Hotel.class);
            if(h != null){
                c.setHotel(h.getBody());
            }
        }
        usuario.setCalificaciones(Arrays.asList(calificaciones));
        return usuario;
    }

    public List<Usuario> completarUsuario(List<Usuario> usuarios){
        for(Usuario usuario :usuarios) {
            Calificacion[] calificaciones = restTemplate.getForObject("http://CALIFICACION-SERVICIO/calificaciones/usuarios/" + usuario.getUsuarioId(), Calificacion[].class);
            for (Calificacion c : calificaciones) {
                ResponseEntity<Hotel> h = restTemplate.getForEntity("http://HOTEL-SERVICIO/hoteles/" + c.getHotelId(), Hotel.class);
                if (h != null) {
                    c.setHotel(h.getBody());
                }
            }
            usuario.setCalificaciones(Arrays.asList(calificaciones));
        }
        return usuarios;
    }

    public Usuario completarUsuarioFeign(Usuario usuario){ //Estos dos metodos usan OpenFeign para comunicar los microservicios. importante Paquete externo.servicio.
        List<Calificacion> calificaciones= calificacionServicio.getCalificaciones(usuario.getUsuarioId());
        for (Calificacion c: calificaciones) {
            c.setHotel(hotelServicio.getHotel(c.getHotelId()));
        }
        usuario.setCalificaciones(calificaciones);
        return usuario;
    }
    public List<Usuario> completarUsuarioFeign(List<Usuario> usuarios){
        for (Usuario u: usuarios) {
            List<Calificacion> calificaciones= calificacionServicio.getCalificaciones(u.getUsuarioId());
            for (Calificacion c: calificaciones) {
                c.setHotel(hotelServicio.getHotel(c.getHotelId()));
            }
            u.setCalificaciones(calificaciones);
        }
        return usuarios;
    }


}
