package com.desk.helpdesk.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desk.helpdesk.model.Usuario;
import com.desk.helpdesk.model.DTO.UsuarioDTO;
import com.desk.helpdesk.service.UsuarioService;

@RestController
@RequestMapping("usuarios")
public class UsuarioResource {

@Autowired private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		return ResponseEntity.ok().body(usuarioService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Integer id){
		return ResponseEntity.ok().body(usuarioService.findById(id));
	}
	
	@GetMapping("/admin") 
	public ResponseEntity<List<Usuario>> findAdmin(){
		return ResponseEntity.ok().body(null);
	}
	
	@GetMapping("/responsavel") 
	public ResponseEntity<List<Usuario>> findResponsavel(){
		return ResponseEntity.ok().body(null);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> save(@RequestBody UsuarioDTO usuarioDTO){
		return ResponseEntity.ok().body(usuarioService.save(usuarioDTO));
	}
}
