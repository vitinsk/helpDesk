package com.desk.helpdesk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desk.helpdesk.model.Servico;
import com.desk.helpdesk.model.Sla;
import com.desk.helpdesk.model.Usuario;

public interface ServicoRepository extends JpaRepository<Servico, Integer>{

	List<Servico> findBySla(Sla sla);
	
	List<Servico> findByResponsavel(Usuario usuario);
}
