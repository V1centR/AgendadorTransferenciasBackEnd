package com.agendador.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.agendador.entities.Agendamento;
import com.agendador.response.AgendamentoResponse;


@Component
public interface AgendamentoService {
	
	Agendamento updateAgendamento(Agendamento agendamento);
	
    List <Agendamento> getAllAgendamento();
    
    List <Agendamento> getTodayAgendamento();
    
    List<Agendamento> findByRangeDate(String startDate, String endDate);
    
    Agendamento getAgendamentoById(long agendamentoId);
    
    void deleteAgendamento(Integer id);

	AgendamentoResponse createAgendamento(Agendamento postData);

}
