package br.gov.prefeitura.mimg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PeriodicidadeAgregado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne(fetch = FetchType.LAZY)
	private Agregado agregado;
	@ManyToOne(fetch = FetchType.LAZY)
	private Periodicidade periodicidade;
	@Column(name = "id_ibge_periodicidade")
	private Integer idIbgePeriodicidade;
	private String frequencia;
	private String inicio;
	private String fim;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Agregado getAgregado() {
		return agregado;
	}
	public void setAgregado(Agregado agregado) {
		this.agregado = agregado;
	}
	public Periodicidade getPeriodo() {
		return periodicidade;
	}
	public void setPeriodo(Periodicidade periodicidade) {
		this.periodicidade = periodicidade;
	}
	public Integer getIdIbgePeriodicidade() {
		return idIbgePeriodicidade;
	}
	public void setIdIbgePeriodicidade(Integer idIbgePeriodicidade) {
		this.idIbgePeriodicidade = idIbgePeriodicidade;
	}
	public String getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(String frequencia) {
		this.frequencia = frequencia;
	}
	public Periodicidade getPeriodicidade() {
		return periodicidade;
	}
	public void setPeriodicidade(Periodicidade periodicidade) {
		this.periodicidade = periodicidade;
	}
	public String getInicio() {
		return inicio;
	}
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	public String getFim() {
		return fim;
	}
	public void setFim(String fim) {
		this.fim = fim;
	}
}
