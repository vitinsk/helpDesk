package com.desk.helpdesk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desk.helpdesk.model.Sla;
import com.desk.helpdesk.repository.SlaRepository;

@Service
public class SlaService {

	@Autowired private SlaRepository slaRepository;
	
	public Sla findById(Integer id) {
		Sla sla = slaRepository.findById(id).orElse(null);
		return sla;
	}
	
	public List<Sla> findAll(){
		return slaRepository.findAll();
	}
	
	public Sla save(Sla slaDTO) {
		Sla sla = slaRepository.save(slaDTO);
		return sla;
	}
}
