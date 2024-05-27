package com.agendador.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agendador.entities.Agendamento;

@Repository
public interface AgendamentoRepo extends JpaRepository<Agendamento, Integer> {
	
	
}
