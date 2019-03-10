package com.desk.helpdesk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desk.helpdesk.model.Chamado;
import com.desk.helpdesk.model.Servico;
import com.desk.helpdesk.model.Usuario;
import com.desk.helpdesk.model.enums.Status;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{

	public List<Chamado> findByStatus(Status status);
	
	public List<Chamado> findByUsuario(Usuario usuario);
	
	public List<Chamado> findByServico(Servico servico);
	
	
}
