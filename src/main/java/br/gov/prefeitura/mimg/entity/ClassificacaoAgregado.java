package br.gov.prefeitura.mimg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ClassificacaoAgregado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sumarizacao_id")
	private SumarizacaoClassificacao sumarizacaoClassificacao;
	@ManyToOne(fetch = FetchType.LAZY)
	private Agregado agregado;
	@ManyToOne(fetch = FetchType.EAGER)
	private Classificacao classificacao;
	
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
	public SumarizacaoClassificacao getSumarizacaoClassificacao() {
		return sumarizacaoClassificacao;
	}
	public void setSumarizacaoClassificacao(SumarizacaoClassificacao sumarizacaoClassificacao) {
		this.sumarizacaoClassificacao = sumarizacaoClassificacao;
	}
	public Agregado getAgregado() {
		return agregado;
	}
	public void setAgregado(Agregado agregado) {
		this.agregado = agregado;
	}
	public Classificacao getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}
}
