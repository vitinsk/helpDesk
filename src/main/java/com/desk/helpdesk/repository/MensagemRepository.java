package com.desk.helpdesk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desk.helpdesk.model.Chamado;
import com.desk.helpdesk.model.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, Integer>{

	List<Mensagem> findByChamado(Chamado chamado);
}
