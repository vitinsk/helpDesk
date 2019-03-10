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

import com.desk.helpdesk.model.Sla;
import com.desk.helpdesk.service.SlaService;

@RestController
@RequestMapping("sla")
public class SlaResource {

@Autowired private SlaService slaService;
	
	@GetMapping
	public ResponseEntity<List<Sla>> findAll(){
		return ResponseEntity.ok().body(slaService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Sla> findById(@PathVariable Integer id){
		return ResponseEntity.ok().body(slaService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Sla> save(@RequestBody Sla sla){
		return ResponseEntity.ok().body(slaService.save(sla));
	}
	
}
