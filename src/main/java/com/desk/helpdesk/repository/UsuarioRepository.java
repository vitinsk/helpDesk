package com.desk.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desk.helpdesk.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	public Usuario findByEmail(String email);
	
}
