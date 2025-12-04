package com.example.demo.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    private  RepositorioUsuario repositorioUsuario;

    public List<Usuario> getAllUsuarios() {
        return repositorioUsuario.findAll();
    }

    public Usuario getUsuario(Long id) {    
        return repositorioUsuario.getReferenceById(id);
    }

    public Usuario addUsuario(Usuario usuario) {
        return repositorioUsuario.saveAndFlush(usuario  );
    }

    public void removeUsuario(Usuario u) {
        repositorioUsuario.delete(u);
    }

    public void removeUsuarioID(Long id) {
        repositorioUsuario.deleteById(id);
    }

    public void updateUsuario(Usuario u) {
        Usuario usuario = repositorioUsuario.getReferenceById(u.getId());
        usuario.setNombre(u.getNombre());
        usuario.setDni(u.getDni());
        usuario.setEmail(u.getEmail());
        usuario.setRol(u.getRol());
        repositorioUsuario.saveAndFlush(usuario);
    }   

 
}
