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
public class Agregado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Pesquisa pesquisa;
	
	private String nome;
	
	@Column(name = "url_agregado")
	private String urlAgregado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Assunto assunto;

	@Column(name = "id_ibge_agregado")
	private Integer idIbgeAgregado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "versao_carga_id")
	private VersaoCarga versaoCarga;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Pesquisa getPesquisa() {
		return pesquisa;
	}
	public void setPesquisa(Pesquisa pesquisa) {
		this.pesquisa = pesquisa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUrlAgregado() {
		return urlAgregado;
	}
	public void setUrlAgregado(String urlAgregado) {
		this.urlAgregado = urlAgregado;
	}
	public Assunto getAssunto() {
		return assunto;
	}
	public void setAssunto(Assunto assunto) {
		this.assunto = assunto;
	}
	public Integer getIdIbgeAgregado() {
		return idIbgeAgregado;
	}
	public void setIdIbgeAgregado(Integer idIbgeAgregado) {
		this.idIbgeAgregado = idIbgeAgregado;
	}
	public VersaoCarga getVersaoCarga() {
		return versaoCarga;
	}
	public void setVersaoCarga(VersaoCarga versaoCarga) {
		this.versaoCarga = versaoCarga;
	}
}
