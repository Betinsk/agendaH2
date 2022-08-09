package com.sales.domain;

import java.io.Serializable;
import java.util.Objects;

public class Estabelecimento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String tipo;
	
	private Endereco endereco;
	
	
	public Estabelecimento() {
		
	}
	
	
	public Estabelecimento(Integer id, String tipo, Endereco endereco) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.endereco = endereco;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
		Estabelecimento other = (Estabelecimento) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public String toString() {
		return "Estabelecimento [id=" + id + ", tipo=" + tipo + ", endereco=" + endereco + "]";
	}
	
	
	
}
