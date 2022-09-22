package com.sales.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sales.domain.Agendamento;
import com.sales.domain.ParametroAgenda;
import com.sales.domain.Usuario;
import com.sales.service.utils.DateUtil;

public class AgendaService {
	
	
	private List<Agendamento/*AgendamentosDTO*/> montarAgenda(ParametroAgenda parametros, List<Agenda> agenda, Date data, /*UserSS*/Usuario user) {
    List<AgendamentosDTO> agendamentos = new ArrayList<>();
    AgendamentosDTO dto = new AgendamentosDTO();

    LocalDateTime primeiroAtendimento = DateUtil.convertToLocalDateTimeViaInstant(data, parametros.getHoraInicio(), parametros.getMinutoInicio());
    LocalDateTime ultimoAtendimento = DateUtil.convertToLocalDateTimeViaInstant(data, parametros.getHoraFim(), parametros.getMinutoFim());
    LocalDateTime intervalo = DateUtil.convertToLocalDateTimeViaInstant(data, parametros.getHoraIntervalo(), parametros.getMinutoIntervalo());


    agendamentos.add(montarAgendamento(primeiroAtendimento, false, parametros.getIntervaloAgenda()));
    primeiroAtendimento = primeiroAtendimento.plusMinutes(parametros.getIntervaloAgenda());


    if (!DateUtil.getHoje(data).isBefore(DateUtil.getHoje(new Date()))) {
        while (primeiroAtendimento.isBefore(ultimoAtendimento)) {
            if (primeiroAtendimento.equals(intervalo)) {
                agendamentos.add(montarAgendamento(primeiroAtendimento, true, parametros.getTempoIntervalo()));
                primeiroAtendimento = primeiroAtendimento.plusMinutes(parametros.getTempoIntervalo());
            } else {
                agendamentos.add(montarAgendamento(primeiroAtendimento, false, parametros.getIntervaloAgenda()));
                primeiroAtendimento = primeiroAtendimento.plusMinutes(parametros.getIntervaloAgenda());
                System.out.println(primeiroAtendimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
            }
        }
    } else {
        agendamentos = toAgendamentoDTO(agenda, parametros);
    }
    
    if (user.hasRole(Perfil.CLIENTE)) {
    	
    	agendamentos = verificaAgendamentoCliente(agendamentos, agenda);
    	
	} else {

		agendamentos = verificaAgendamento(agendamentos, agenda);
		
	}
    

    return agendamentos;
}


private AgendamentosDTO montarAgendamento(LocalDateTime dataAgendamento, Boolean intervalo, Integer tempoIntervalo) {
    dataAgendamento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    AgendamentosDTO dto = new AgendamentosDTO();

    dto.setHorario(dataAgendamento);
    dto.setHorarioFim(dataAgendamento.plusMinutes(tempoIntervalo));
    if (intervalo) {
        dto.setStatus(Status.INTERVALO);
    } else {
        dto.setStatus(Status.ABERTO);
    }
    return dto;
}

private List<AgendamentosDTO> verificaAgendamento(List<AgendamentosDTO> agendamentos, List<Agenda> agendas) {
    if (!agendas.isEmpty()) {
        for (AgendamentosDTO agendamento : agendamentos) {
            for (Agenda agenda : agendas) {
                if (agendamento.getHorario().isEqual(DateUtil.convertToLocalDateTimeViaInstant(agenda.getData()))) {
                    agendamento.setCodigo(agenda.getCodigo());
                    agendamento.setStatus(agenda.getStatus());
                    agendamento.setCliente(agenda.getCliente() == null ? null : new ClienteDTO(agenda.getCliente()));
                    agendamento.setServico(agenda.getServico() == null ? null : new ServicoDTO(agenda.getServico()));
                }
            }

        }
    }
    return agendamentos;
}

private List<AgendamentosDTO> verificaAgendamentoCliente(List<AgendamentosDTO> agendamentos, List<Agenda> agendas) {
    if (!agendas.isEmpty()) {
    	
//    	agendamentos.forEach(agendamento -> {        		
//    		agendas.forEach(agenda -> {
//                if (agendamento.getHorario().isEqual(DateUtil.convertToLocalDateTimeViaInstant(agenda.getData()))) {
//                	agendamentos.remove(agendamento);
//                }
//    		});
//    		if (agendamento != null && Status.INTERVALO.equals(agendamento.getStatus())) {
//    			agendamentos.remove(agendamento);
//			}
//    	});
    	
        for (int i = 0; i < agendamentos.size(); i++) {
            for (Agenda agenda : agendas) {
                if (agendamentos.get(i) != null && 
                		agendamentos.get(i).getHorario().isEqual(DateUtil.convertToLocalDateTimeViaInstant(agenda.getData())) || 
                		Status.INTERVALO.equals(agendamentos.get(i).getStatus())) {
                	
                	agendamentos.remove(agendamentos.get(i));
                	if (i == agendamentos.size()) {
						break;
					}
                }
            }

        }
    }
    return agendamentos;
}
	
	
}
