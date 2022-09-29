package com.sales;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sales.domain.ParametroAgenda;
import com.sales.service.utils.DateUtil;

@SpringBootApplication
public class AgendaAppApplication implements CommandLineRunner {

	@Autowired
	
	
	public static void main(String[] args) {
		SpringApplication.run(AgendaAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		
		ParametroAgenda parametroAgenda = new ParametroAgenda(null, null, true, false, false, false, false, false, false, null, 10, 05, null, null, null, null, null, null, null, null);
		
		DateUtil date = new DateUtil();
		
		System.out.println(parametroAgenda.getHoraInicio()+" "+ parametroAgenda.getMinutoInicio());
		System.out.println(DateUtil.convertToLocalDateTimeViaInstant(new Date(), parametroAgenda.getHoraInicio(), parametroAgenda.getMinutoInicio()));
	}

	

}
