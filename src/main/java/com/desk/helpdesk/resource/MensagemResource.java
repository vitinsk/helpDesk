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

import com.desk.helpdesk.model.Mensagem;
import com.desk.helpdesk.model.DTO.MensagemDTO;
import com.desk.helpdesk.service.MensagemService;

@RestController
@RequestMapping("mensagens")
public class MensagemResource {

@Autowired private MensagemService mensagemService;
	
	@GetMapping
	public ResponseEntity<List<MensagemDTO>> findAll(){
		return ResponseEntity.ok().body(mensagemService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MensagemDTO> findById(@PathVariable Integer id){
		return ResponseEntity.ok().body(mensagemService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Mensagem> save(@RequestBody Mensagem mensagem){
		return ResponseEntity.ok().body(mensagemService.save(mensagem));
	}
	
	@GetMapping("/chamados/{codigoChamado}")
	public ResponseEntity<List<MensagemDTO>> findByChamado(@PathVariable Integer codigoChamado){
		return ResponseEntity.ok().body(mensagemService.findByChamado(codigoChamado));
	}
}
