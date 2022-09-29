package com.sales.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

	@Entity(name = "tb_parametro_agenda")
	public class ParametroAgenda implements Serializable {
    private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    @ManyToOne
	    @JoinColumn(name = "profissional")
	    private Profissional profissional;

	    private boolean segunda;
	    private boolean terca;
	    private boolean quarta;
	    private boolean quinta;
	    private boolean sexta;
	    private boolean sabado;
	    private boolean domingo;

	    @Column(name = "intervalo_agenda")
	    private Integer intervaloAgenda;

	    private Integer horaInicio;
	    private Integer minutoInicio;

	    private Integer horaFim;
	    private Integer minutoFim;

	    private Integer horaIntervalo;
	    private Integer minutoIntervalo;
	    private Integer tempoIntervalo;

	    private Date dataCadastro;
	    private Date dataAtualizacao;

	    @JsonIgnore
	    @ManyToOne
	    @JoinColumn(name = "estabelecimento")
	    private Estabelecimento estabelecimento;

	    public ParametroAgenda (){
	        this.dataCadastro = new Date();
	    }
	    
	    

		public ParametroAgenda(Integer id, Profissional profissional, boolean segunda, boolean terca, boolean quarta,
				boolean quinta, boolean sexta, boolean sabado, boolean domingo, Integer intervaloAgenda,
				Integer horaInicio, Integer minutoInicio, Integer horaFim, Integer minutoFim, Integer horaIntervalo,
				Integer minutoIntervalo, Integer tempoIntervalo, Date dataCadastro, Date dataAtualizacao,
				Estabelecimento estabelecimento) {
			super();
			this.id = id;
			this.profissional = profissional;
			this.segunda = segunda;
			this.terca = terca;
			this.quarta = quarta;
			this.quinta = quinta;
			this.sexta = sexta;
			this.sabado = sabado;
			this.domingo = domingo;
			this.intervaloAgenda = intervaloAgenda;
			this.horaInicio = horaInicio;
			this.minutoInicio = minutoInicio;
			this.horaFim = horaFim;
			this.minutoFim = minutoFim;
			this.horaIntervalo = horaIntervalo;
			this.minutoIntervalo = minutoIntervalo;
			this.tempoIntervalo = tempoIntervalo;
			this.dataCadastro = dataCadastro;
			this.dataAtualizacao = dataAtualizacao;
			this.estabelecimento = estabelecimento;
		}



		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Profissional getProfissional() {
			return profissional;
		}

		public void setProfissional(Profissional profissional) {
			this.profissional = profissional;
		}

		public boolean isSegunda() {
			return segunda;
		}

		public void setSegunda(boolean segunda) {
			this.segunda = segunda;
		}

		public boolean isTerca() {
			return terca;
		}

		public void setTerca(boolean terca) {
			this.terca = terca;
		}

		public boolean isQuarta() {
			return quarta;
		}

		public void setQuarta(boolean quarta) {
			this.quarta = quarta;
		}

		public boolean isQuinta() {
			return quinta;
		}

		public void setQuinta(boolean quinta) {
			this.quinta = quinta;
		}

		public boolean isSexta() {
			return sexta;
		}

		public void setSexta(boolean sexta) {
			this.sexta = sexta;
		}

		public boolean isSabado() {
			return sabado;
		}

		public void setSabado(boolean sabado) {
			this.sabado = sabado;
		}

		public boolean isDomingo() {
			return domingo;
		}

		public void setDomingo(boolean domingo) {
			this.domingo = domingo;
		}

		public Integer getIntervaloAgenda() {
			return intervaloAgenda;
		}

		public void setIntervaloAgenda(Integer intervaloAgenda) {
			this.intervaloAgenda = intervaloAgenda;
		}

		public Integer getHoraInicio() {
			return horaInicio;
		}

		public void setHoraInicio(Integer horaInicio) {
			this.horaInicio = horaInicio;
		}

		public Integer getMinutoInicio() {
			return minutoInicio;
		}

		public void setMinutoInicio(Integer minutoInicio) {
			this.minutoInicio = minutoInicio;
		}

		public Integer getHoraFim() {
			return horaFim;
		}

		public void setHoraFim(Integer horaFim) {
			this.horaFim = horaFim;
		}

		public Integer getMinutoFim() {
			return minutoFim;
		}

		public void setMinutoFim(Integer minutoFim) {
			this.minutoFim = minutoFim;
		}

		public Integer getHoraIntervalo() {
			return horaIntervalo;
		}

		public void setHoraIntervalo(Integer horaIntervalo) {
			this.horaIntervalo = horaIntervalo;
		}

		public Integer getMinutoIntervalo() {
			return minutoIntervalo;
		}

		public void setMinutoIntervalo(Integer minutoIntervalo) {
			this.minutoIntervalo = minutoIntervalo;
		}

		public Integer getTempoIntervalo() {
			return tempoIntervalo;
		}

		public void setTempoIntervalo(Integer tempoIntervalo) {
			this.tempoIntervalo = tempoIntervalo;
		}

		public Date getDataCadastro() {
			return dataCadastro;
		}

		public void setDataCadastro(Date dataCadastro) {
			this.dataCadastro = dataCadastro;
		}

		public Date getDataAtualizacao() {
			return dataAtualizacao;
		}

		public void setDataAtualizacao(Date dataAtualizacao) {
			this.dataAtualizacao = dataAtualizacao;
		}

		public Estabelecimento getEstabelecimento() {
			return estabelecimento;
		}

		public void setEstabelecimento(Estabelecimento estabelecimento) {
			this.estabelecimento = estabelecimento;
		}
	
	    
}
