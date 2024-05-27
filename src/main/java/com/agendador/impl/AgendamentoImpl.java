package com.agendador.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
	
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  

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
		return repository.findToday(dateStampNow());
	}

	@Override
	public List<Agendamento> findByRangeDate(String startDate, String endDate) {
		return repository.findByRangeDate(startDate, endDate);
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
	
	private String dateStampNow() {
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
	
	

}