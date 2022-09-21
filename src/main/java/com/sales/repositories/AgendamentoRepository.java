package com.sales.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sales.domain.Agendamento;
import com.sales.domain.Profissional;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer>{

	Object findAllByProfissionalAndDate(Profissional profissional, Date date);
	
	/*@Query(native =true, value= "Select * from Agendamento where profissional = x and data = x")
	void FindbyProfissionalAndDate(Integer Agendamento, Date date) {
		*/
	
	
}
