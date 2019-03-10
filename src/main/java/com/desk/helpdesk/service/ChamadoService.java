package com.desk.helpdesk.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desk.helpdesk.model.Chamado;
import com.desk.helpdesk.model.Mensagem;
import com.desk.helpdesk.model.Servico;
import com.desk.helpdesk.model.Usuario;
import com.desk.helpdesk.model.DTO.ChamadoDTO;
import com.desk.helpdesk.model.enums.Status;
import com.desk.helpdesk.repository.ChamadoRepository;
import com.desk.helpdesk.service.exception.DataIntegrityException;

@Service
public class ChamadoService {

	@Autowired private ChamadoRepository chamadoRepository;
	@Autowired private MensagemService mensagemService;
	@Autowired private ServicoService servicoService;
	@Autowired private UsuarioService usuarioService;
	
	public Chamado findById(Integer id) {
		Chamado chamado = chamadoRepository.findById(id).orElse(null);
		return chamado;
	}
	
	public List<Chamado> findAll(){
		return chamadoRepository.findAll();
	}
	
	private Chamado save(Chamado chamado) {
		return chamadoRepository.save(chamado);
	}
	
	public Chamado alterarStatus(Integer codigo, String status) {
		Chamado chamado = findById(codigo);
		if (!chamado.getStatus().equals(Status.FINALIZADO)) {
			
		chamado.setStatus(Status.valueOf(status));
	
		if (chamado.getStatus().equals(Status.FINALIZADO)) {
			chamado.setDataFim(new Date());
		}
		
		save(chamado);
		}
		else {
			throw new DataIntegrityException("Este chamado não pode mais ser alterado.");
		}
		return chamado;
	}
	
	public Chamado abrirChamado(ChamadoDTO chamadoDTO) {
		
		Usuario usuario = usuarioService.findById(chamadoDTO.getUsuario());
		Servico servico = servicoService.findById(chamadoDTO.getServico());
		
		Chamado chamado = new Chamado(chamadoDTO.getTitulo(), 
				chamadoDTO.getObservacao(), 
				usuario, servico);
		
		Mensagem mensagem = new Mensagem(chamadoDTO.getMensagem(), new Date(), chamado);
	
		chamado = save(chamado);
		mensagem = mensagemService.save(mensagem);
		
		return chamado;
		
	}

	public Chamado update(Integer id, ChamadoDTO chamadoDTO) {
		Chamado chamado = findById(id);
		if (chamadoDTO.getObservacao() != null) {
			chamado.setObservacao(chamadoDTO.getObservacao());
		}
		if (chamadoDTO.getTitulo() != null) {
			chamado.setTitulo(chamadoDTO.getTitulo());
		}
		if (chamadoDTO.getServico() != null) {
			Servico servico = servicoService.findById(chamadoDTO.getServico());
			chamado.setServico(servico);
		}
		
		chamado = save(chamado);
		return chamado;
	}
	
	private boolean validaFinalizacao(Chamado chamado, String status, Integer user) {
		Usuario usuario = usuarioService.findById(user);
		if (Status.valueOf(status).equals(Status.FINALIZADO)) {
			
		}
		return false;
	}
	
	private boolean validaAlteracaoStatus(Chamado chamado, Integer user, Integer resp){
		Usuario usuario = usuarioService.findById(user);
		Usuario responsavel = usuarioService.findById(resp);
		if (chamado.getUsuario().equals(usuario) || chamado.getServico().getResponsavel().equals(responsavel)) {
			return true;
		}
		return false;
	}
	
}
