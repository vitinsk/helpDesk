package com.desk.helpdesk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.desk.helpdesk.model.Usuario;
import com.desk.helpdesk.repository.UsuarioRepository;
import com.desk.helpdesk.security.UserSS;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Usuario cli = repo.findByEmail(email.toLowerCase());
		if (cli == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSS(cli.getCodigo(), cli.getEmail().toLowerCase(), cli.getSenha(), cli.getPerfis());
	
	}

}
