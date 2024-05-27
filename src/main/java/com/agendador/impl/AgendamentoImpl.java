package com.agendador.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agendador.entities.Agendamento;
import com.agendador.repo.AgendamentoRepo;
import com.agendador.service.AgendamentoService;


@Service("agendamentoImpl")
public class AgendamentoImpl implements AgendamentoService{

	@Autowired
	AgendamentoRepo repository;

	@Override
	public Agendamento updateAgendamento(Agendamento agendamento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Agendamento> getAllAgendamento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Agendamento> getTodayAgendamento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Agendamento> findByRangeDate(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Agendamento getAgendamentoById(long agendamentoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAgendamento(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	

}