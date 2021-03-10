package br.gov.prefeitura.mimg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Periodicidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "id_ibge_periodicidade")
	private String idIbgePeriodicidade;
	private String descricao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIdIbgePeriodicidade() {
		return idIbgePeriodicidade;
	}
	public void setIdIbgePeriodicidade(String idIbgePeriodicidade) {
		this.idIbgePeriodicidade = idIbgePeriodicidade;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
