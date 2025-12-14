package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Usuario;
import com.example.demo.model.UsuarioService;

@Controller
public class UsuarioViewController {

	@Autowired
    private UsuarioService usuarioService;
	
	//Devuelve el formulario de index de usuarios  
	@GetMapping("/")
	public String indexUsuarioView() {
		return "indexU";
	}

	//Devuelve el formulario para anyadir una nueva cuenta con una cuenta vacia
	@GetMapping("/addUsuario")
	public String addUsuarioView(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "addUsuario";
	}

	//Devuelve el formulario para listar las cuentas del sistema
	@GetMapping("/listUsuario")
	public String listUsuarioView(Model model) {
		
		model.addAttribute("usuarios", usuarioService.getAllUsuarios());
		
		return "listUsuario";
	}


	//Devuelve el formulario para editar una Cuenta
	@GetMapping("/editUsuario/{id}")
	public String editUsuarioView(@PathVariable("id") Long id, Model model) {

		model.addAttribute("usuario", usuarioService.getUsuario(id));
		return "updateUsuario";
	}
    
}
