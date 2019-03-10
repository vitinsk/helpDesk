package com.desk.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desk.helpdesk.model.Sla;

public interface SlaRepository extends JpaRepository<Sla, Integer>{

}
