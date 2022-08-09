package com.sales.domain;

import java.io.Serializable;
import java.util.Objects;

public class Profissional implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String cpf;
	private String tipo;
	private String email;
	
	private Estabelecimento estabelecimento;
	
	public Profissional() {
		
	}

	public Profissional(Integer id, String nome, String cpf, String tipo, String email,
			Estabelecimento estabelecimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.tipo = tipo;
		this.email = email;
		this.estabelecimento = estabelecimento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
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
		Profissional other = (Profissional) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Profissional [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", tipo=" + tipo + ", email=" + email
				+ ", estabelecimento=" + estabelecimento + "]";
	}
	

	
	
}
