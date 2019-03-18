package com.desk.helpdesk.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desk.helpdesk.model.Chamado;
import com.desk.helpdesk.model.DTO.ChamadoDTO;
import com.desk.helpdesk.model.DTO.ChamadoInfoDTO;
import com.desk.helpdesk.service.ChamadoService;

@RestController
@RequestMapping("chamados")
public class ChamadoResource {

	@Autowired private ChamadoService chamadoService;
	
	
	@GetMapping
	public ResponseEntity<List<Chamado>> findAll(){
		return ResponseEntity.ok().body(chamadoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Chamado> findById(@PathVariable Integer id){
		return ResponseEntity.ok().body(chamadoService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Chamado> save(@RequestBody ChamadoDTO chamadoDTO){
		return ResponseEntity.ok().body(chamadoService.abrirChamado(chamadoDTO));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Chamado> update(@PathVariable Integer id, @RequestBody ChamadoDTO chamadoDTO){
		return ResponseEntity.ok().body(chamadoService.update(id,chamadoDTO));
	}
	
	@PutMapping("/{codigo}/{status}")
	public ResponseEntity<Chamado> alterarStatus(@PathVariable Integer codigo, @PathVariable String status){
		return ResponseEntity.ok().body(chamadoService.alterarStatus(codigo, status));
	}
	
	@GetMapping("/informacoes")
	public ResponseEntity<ChamadoInfoDTO> findInformacoes(){
		return ResponseEntity.ok().body(chamadoService.findInformacoes());
	}
	
	
}
