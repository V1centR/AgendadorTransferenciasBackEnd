package com.agendador.response;

import com.agendador.entities.Agendamento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgendamentoResponse {
	
	private Agendamento agendamento;
    private String status;
    private String message;
    
    public AgendamentoResponse(Agendamento agendamento) {
        this.agendamento = agendamento;
        this.status = "success";
        this.message = "Transação registrada com sucesso";
    }

    

}
