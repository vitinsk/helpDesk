package com.desk.helpdesk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desk.helpdesk.model.Servico;
import com.desk.helpdesk.repository.ServicoRepository;

@Service
public class ServicoService {

	@Autowired ServicoRepository servicoRepository;
	

	public Servico findById(Integer id) {
		Servico servico = servicoRepository.findById(id).orElse(null);
		return servico;
	}
	
	public List<Servico> findAll(){
		return servicoRepository.findAll();
	}
	
	public Servico save(Servico servicoDTO) {
		Servico servico = servicoRepository.save(servicoDTO);
		return servico;
	}
	
	public Servico toDto(Servico servico) {
		return null;
	}
}
