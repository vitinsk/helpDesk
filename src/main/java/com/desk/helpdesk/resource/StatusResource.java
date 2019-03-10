package com.desk.helpdesk.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desk.helpdesk.model.enums.Status;

@RestController
@RequestMapping("status")
public class StatusResource {

	@GetMapping
	public ResponseEntity<Status[]> findAll(){		
		return ResponseEntity.ok().body(Status.values());
	}
}
