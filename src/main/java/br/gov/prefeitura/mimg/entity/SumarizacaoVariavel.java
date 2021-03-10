package br.gov.prefeitura.mimg.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SumarizacaoVariavel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String  sumarizacao;
	@ManyToOne(fetch = FetchType.LAZY)
	private Variavel variavel;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSumarizacao() {
		return sumarizacao;
	}
	public void setSumarizacao(String sumarizacao) {
		this.sumarizacao = sumarizacao;
	}
	public Variavel getVariavel() {
		return variavel;
	}
	public void setVariavel(Variavel variavel) {
		this.variavel = variavel;
	}
}
