package com.agendador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agendador.entities.Agendamento;
import com.agendador.impl.AgendamentoImpl;


@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {
	
	@Autowired
	AgendamentoImpl service;
	
	
//	@GetMapping("/all")
//	public List<Agendamento> getAll() {
//		return service.getAllAgendamento();
//	}
	
	@CrossOrigin
	@GetMapping("/today")
	public List<Agendamento> getToday() {
		return service.getTodayAgendamento();
	}
	
	@CrossOrigin
	@GetMapping("/range/{startDate}/{endDate}")
	public List<Agendamento> getByRangeDate(@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate) {
		return service.findByRangeDate(startDate,endDate);
	}
	

}
