package br.gov.prefeitura.mimg.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ResultadoAgregado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne(fetch = FetchType.LAZY)
	private Agregado agregado;
	@ManyToOne(fetch = FetchType.LAZY)
	private Variavel variavel;
	@ManyToOne(fetch = FetchType.LAZY)
	private ClassificacaoAgregado classificacaoAgregado;
	@ManyToOne(fetch = FetchType.LAZY)
	private Localidade localidade;
	@Column(name = "referencia_serie")
	private String referenciaSerie;
	@Column(name = "valor_serie")
	private BigDecimal valorSerie;
	
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
	public Variavel getVariavel() {
		return variavel;
	}
	public void setVariavel(Variavel variavel) {
		this.variavel = variavel;
	}
	public ClassificacaoAgregado getClassificacaoAgregado() {
		return classificacaoAgregado;
	}
	public void setClassificacaoAgregado(ClassificacaoAgregado classificacaoAgregado) {
		this.classificacaoAgregado = classificacaoAgregado;
	}
	public String getReferenciaSerie() {
		return referenciaSerie;
	}
	public void setReferenciaSerie(String referenciaSerie) {
		this.referenciaSerie = referenciaSerie;
	}
	public BigDecimal getValorSerie() {
		return valorSerie;
	}
	public void setValorSerie(BigDecimal valorSerie) {
		this.valorSerie = valorSerie;
	}
	public Localidade getLocalidade() {
		return localidade;
	}
	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}
}
