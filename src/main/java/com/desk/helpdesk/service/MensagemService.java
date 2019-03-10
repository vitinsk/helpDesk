package com.desk.helpdesk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desk.helpdesk.model.Chamado;
import com.desk.helpdesk.model.Mensagem;
import com.desk.helpdesk.model.enums.Status;
import com.desk.helpdesk.repository.ChamadoRepository;
import com.desk.helpdesk.repository.MensagemRepository;
import com.desk.helpdesk.service.exception.DataIntegrityException;

@Service
public class MensagemService {

@Autowired private MensagemRepository mensagemRepository;
@Autowired private ChamadoService chamadoService;
	
	public Mensagem findById(Integer id) {
		Mensagem mensagem = mensagemRepository.findById(id).orElse(null);
		return mensagem;
	}
	
	public List<Mensagem> findAll(){
		return mensagemRepository.findAll();
	}
	
	public Mensagem save(Mensagem msg) {
		Chamado chamado = chamadoService.findById(msg.getChamado().getCodigo());
		Mensagem mensagem = null;
		if (!chamado.getStatus().equals(Status.FINALIZADO)) {
			mensagem = mensagemRepository.save(msg);
		}else {
			throw new DataIntegrityException("Este chamado não pode mais receber mensagens.");
		}
		
		return mensagem;
	}
	
	List<Mensagem> findByChamado(Chamado chamado){
		List<Mensagem> mensagens = mensagemRepository.findByChamado(chamado);
		return mensagens;
	}
	
	public void toDto(Mensagem mensagem) {
		
	}
}
