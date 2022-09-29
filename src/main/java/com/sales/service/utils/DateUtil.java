package com.sales.service.utils;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;


public class DateUtil {

	public static LocalDateTime convertToLocalDateTimeViaInstant(Date data, Integer horaInicio, Integer minutoInicio) {
		
		Calendar cal = Calendar.getInstance();
			cal.setTime(data);
			int dia = cal.get(Calendar.DAY_OF_MONTH);
			int mes = cal.get(Calendar.MONTH);
			int ano = cal.get(Calendar.YEAR);
			
		LocalDateTime localDateTime = LocalDateTime.of(ano, mes+ 1, dia, horaInicio, minutoInicio);
		
		return localDateTime;
	}
	
}
