package com.desk.helpdesk.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desk.helpdesk.model.Chamado;
import com.desk.helpdesk.model.Mensagem;
import com.desk.helpdesk.model.Usuario;
import com.desk.helpdesk.model.DTO.MensagemDTO;
import com.desk.helpdesk.model.enums.Status;
import com.desk.helpdesk.repository.MensagemRepository;
import com.desk.helpdesk.service.exception.DataIntegrityException;

@Service
public class MensagemService {

@Autowired private MensagemRepository mensagemRepository;
@Autowired private ChamadoService chamadoService;
@Autowired private UsuarioService usuarioService;
	
	public MensagemDTO findById(Integer id) {
		Mensagem mensagem = mensagemRepository.findById(id).orElse(null);
		return toDto(Arrays.asList(mensagem)).get(0);
	}
	
	public List<MensagemDTO> findAll(){
		return toDto(mensagemRepository.findAll());
	}
	
	public Mensagem save(Mensagem msg) {
		Chamado chamado = chamadoService.findById(msg.getChamado().getCodigo());
		Usuario usuario = usuarioService.findById(msg.getUsuario().getCodigo());
		if (usuario == null || msg.getUsuario().getCodigo() == null) {
			throw new DataIntegrityException("Este Usuario não existe.");
		}else {
			msg.setUsuario(usuario);
		}
		Mensagem mensagem = null;
		if (chamado == null) {
			throw new DataIntegrityException("Este chamado não existe.");
		}
		if (!chamado.getStatus().equals(Status.FINALIZADO)) {
			mensagem = mensagemRepository.save(msg);
		}else {
			throw new DataIntegrityException("Este chamado não pode mais receber mensagens.");
		}
		
		return mensagem;
	}
	
	public List<MensagemDTO> findByChamado(Integer codigoChamado){
		Chamado chamado = chamadoService.findById(codigoChamado);
		List<Mensagem> mensagens = mensagemRepository.findByChamado(chamado);
		return toDto(mensagens);
	}
	
	private List<MensagemDTO> toDto(List<Mensagem> mensagens) {
		List<MensagemDTO> msgDTO = new ArrayList<>();
		if (!mensagens.isEmpty()) {
			for(Mensagem msg : mensagens) {
				msgDTO.add(new MensagemDTO(msg));
			}	
		}			
		return msgDTO;
	}
}
