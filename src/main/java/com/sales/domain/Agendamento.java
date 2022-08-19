package com.sales.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Agendamento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date date;

	@OneToOne
	@JoinColumn(name="servico")
	private Servico servico;
	
	@OneToOne
	@JoinColumn(name="cliente")
	private Cliente cliente;

	@OneToOne
	@JoinColumn(name="profissional")
	private Profissional profissional;
	
	public Agendamento() {
		
	}

	public Agendamento(Integer id, Date date, Servico servico, Cliente cliente,
			Profissional profissional) {
		super();
		this.id = id;
		this.date = date;
		this.servico = servico;
		this.cliente = cliente;
		this.profissional = profissional;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agendamento other = (Agendamento) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Agendamento [id=" + id + ", date=" + date + ", servico=" + servico + ", cliente=" + cliente
				+ ", profissional=" + profissional + "]";
	}


	
	
	
}
