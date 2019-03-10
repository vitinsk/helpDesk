package com.desk.helpdesk.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desk.helpdesk.model.Servico;
import com.desk.helpdesk.service.ServicoService;

@RestController
@RequestMapping("servicos")
public class ServicoResource {

@Autowired private ServicoService servicoService;
	
	@GetMapping
	public ResponseEntity<List<Servico>> findAll(){
		return ResponseEntity.ok().body(servicoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Servico> findById(@PathVariable Integer id){
		return ResponseEntity.ok().body(servicoService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Servico> save(@RequestBody Servico servico){
		return ResponseEntity.ok().body(servicoService.save(servico));
	}
}
