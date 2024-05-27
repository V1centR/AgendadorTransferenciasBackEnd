package com.agendador.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agendador.entities.Agendamento;
import com.agendador.repo.AgendamentoRepo;
import com.agendador.response.AgendamentoResponse;
import com.agendador.service.AgendamentoService;


@Service("agendamentoImpl")
public class AgendamentoImpl implements AgendamentoService{

	@Autowired
	AgendamentoRepo repository;
	
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	private double taxRateApply;
	private boolean blockTransaction;
	
	@Override
	public AgendamentoResponse createAgendamento(Agendamento postData) {
	 
		double taxRate = calculateTaxRate(postData.getDataTransferencia());
		
		String messageTax = "Taxa 0 não aplicável";
		String message50Days = "Transações +50 dias não podem ser registradas";
		
		if (this.blockTransaction) {
	        return new AgendamentoResponse("blocked", message50Days);
	    }
	    
	    if (this.taxRateApply == 0.0) {
	        return new AgendamentoResponse("blocked", messageTax);
	    }

	    postData.setDataRegistro(dateStampNow());
	    postData.setTaxaAplicavel(taxRate);
	    postData.setStatus("AP");

	    Agendamento savedAgendamento = repository.save(postData);
	    return new AgendamentoResponse(savedAgendamento);
	}

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
	
	public double calculateTaxRate(String inputDate) {

        LocalDate providedDate = LocalDate.parse(inputDate, dtf);
        LocalDate currentDate = LocalDate.now();

        long diferencaDias = ChronoUnit.DAYS.between(currentDate,providedDate);

        this.taxRateApply = (diferencaDias == 0) ? 2.5
                : (diferencaDias >= 1 && diferencaDias <= 10) ? 0.0
                : (diferencaDias >= 11 && diferencaDias <= 20) ? 8.2
                : (diferencaDias >= 21 && diferencaDias <= 30) ? 6.9
                : (diferencaDias >= 31 && diferencaDias <= 40) ? 4.7
                : (diferencaDias >= 41 && diferencaDias <= 50) ? 1.7
                : 0.0;
        
        this.blockTransaction = diferencaDias > 50;

        return this.taxRateApply;
    }
	
	private String dateStampNow() {
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
	
	

}