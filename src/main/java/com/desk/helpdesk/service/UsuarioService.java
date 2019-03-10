package com.desk.helpdesk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desk.helpdesk.model.Usuario;
import com.desk.helpdesk.model.DTO.UsuarioDTO;
import com.desk.helpdesk.repository.UsuarioRepository;
import com.desk.helpdesk.service.exception.DataIntegrityException;
import com.desk.helpdesk.service.exception.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired UsuarioRepository usuarioRepository;
	//@Autowired	private BCryptPasswordEncoder encode;

	public Usuario findById(Integer id) {
		Usuario usuario = usuarioRepository.findById(id).orElse(null);
		return usuario;
	}
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}

	public Usuario save(UsuarioDTO usuarioDTO) {
		
		Usuario user = usuarioRepository.findByEmail(usuarioDTO.getEmail());
		if (user != null) {
			throw new DataIntegrityException("Email já cadastrado");
		}
		Usuario usuario = new Usuario(usuarioDTO.getNome(), usuarioDTO.getEmail().toLowerCase(), usuarioDTO.getSenha());
		usuario = usuarioRepository.save(usuario);
		return usuario;
	}
}
