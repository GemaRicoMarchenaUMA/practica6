package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Usuario;
import com.example.demo.model.UsuarioService;

@RestController
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    // Devuelve todas las personas
    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios(){
        return usuarioService.getAllUsuarios();
    }

    // Devuelve una persona por ID
    @GetMapping("/usuario/{id}")
    public Usuario getUsuario(@PathVariable("id") Long id) {
        return usuarioService.getUsuario(id);
    }

    // Crea una persona con el objeto Persona recibido en formato JSON
    @PostMapping(value = "/usuario",     consumes = {MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<?> saveUsuario(@RequestBody Usuario usuario) {
        try{
            usuarioService.addUsuario(usuario);
            return ResponseEntity.ok().body("Un nuevo Usuario se ha anyadido");
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body("El Usuario ya existe");
        }
	}

    // Actualiza una persona con el objeto Persona
    @PutMapping("/usuario")
    public ResponseEntity<?> updateUsuario (Usuario usuario){    {
        try{
            usuarioService.updateUsuario(usuario);
            return ResponseEntity.ok().body("El Usuario se ha actualizado");
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body("Error al actualizar el Usuario");
        }}
    }
    
    // Elimina una persona pasando el objeto Persona
    @DeleteMapping("/usuario")
    public ResponseEntity<?> deleteUsuario(@RequestBody Usuario usuario){
        try{
            usuarioService.removeUsuario(usuario);
            return ResponseEntity.ok().body("El Usuario se ha eliminado");
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body("Error al eliminar el Usuario");
        }
    }

    // Otra forma de eliminar una persona con el ID
    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable("id") Long id) {
        try{
            usuarioService.removeUsuarioID(id);
            return ResponseEntity.ok().body("El Usuario se ha eliminado");
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body("Error al eliminar el Usuario");
        }
    }
}