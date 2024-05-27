package com.agendador.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AGENDAMENTO")
public class Agendamento {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "data_sequence")
	@SequenceGenerator(name = "data_sequence", sequenceName = "data_sequence_custom",initialValue = 1, allocationSize = 3)
    @Column(name = "ID", nullable = false)
    public Long id;
	
	@Column(name = "DATAREGISTRO", length = 50, nullable = false)
    public String dataRegistro;
	
	@Column(name = "DATATRANSFERENCIA", nullable = false)
	public String dataTransferencia;
	
	@Column(name = "VALORTRANSFERENCIA", nullable = false)
	public String valorTransferencia;
	
	@Column(name = "CTAORIGEM", nullable = false)
	public String ctaOrigem;
	
	@Column(name = "CTADESTINO", nullable = false)
	public String ctaDestino;
	
	@Column(name = "TAXAAPLICAVEL", nullable = false)
	public double taxaAplicavel;
	
	@Column(name = "STATUS", nullable = false)
	public String status;
	
}
