package br.gov.prefeitura.mimg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nivel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	@Column(name = "id_ibge_nivel")
	private String idIbgeNivel;

	
	public Integer getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getIdIbgeNivel() {
		return idIbgeNivel;
	}

	public void setIdIbgeNivel(String idIbgeNivel) {
		this.idIbgeNivel = idIbgeNivel;
	}
}
