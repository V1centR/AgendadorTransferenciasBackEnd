package com.agendador.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.agendador.entities.Agendamento;
import com.agendador.impl.AgendamentoImpl;

@WebMvcTest(AgendamentoController.class)
public class AgendamentoControllerTest {
	
	
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private AgendamentoImpl service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    public void testGetToday() throws Exception {
    	
    	
    	Agendamento agendamento1 = new Agendamento();
        
        agendamento1.setDataRegistro("26-05-2024");
        agendamento1.setDataTransferencia("30-06-2024");
        agendamento1.setValorTransferencia("14289.99");
        agendamento1.setCtaOrigem("KK3YK3NF4X");
        agendamento1.setCtaDestino("QQ4YK4NF4X");
        agendamento1.setTaxaAplicavel(4.7);
        agendamento1.setStatus("AP");

        Agendamento agendamento2 = new Agendamento();
        agendamento2.setDataRegistro("27-05-2024");
        agendamento2.setDataTransferencia("01-07-2024");
        agendamento2.setValorTransferencia("15800.50");
        agendamento2.setCtaOrigem("LL3YK3NF4X");
        agendamento2.setCtaDestino("RR4YK4NF4X");
        agendamento2.setTaxaAplicavel(5.2);
        agendamento2.setStatus("OK");
    	
        List<Agendamento> agendamentos = Arrays.asList(agendamento1, agendamento2);

        when(service.getTodayAgendamento()).thenReturn(agendamentos);

        mockMvc.perform(get("/agendamento/today"))
                .andExpect(status().isOk());
                

        verify(service, times(1)).getTodayAgendamento();
        verifyNoMoreInteractions(service);
    }

}
