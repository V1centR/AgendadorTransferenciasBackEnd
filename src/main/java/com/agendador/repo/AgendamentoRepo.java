package com.agendador.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.agendador.entities.Agendamento;

@Repository
public interface AgendamentoRepo extends JpaRepository<Agendamento, Integer> {
	
	@Query(value="SELECT * FROM AGENDAMENTO WHERE DATAREGISTRO = :today ORDER BY ID DESC",nativeQuery = true)
	List<Agendamento> findToday(String today);
	
	
}
