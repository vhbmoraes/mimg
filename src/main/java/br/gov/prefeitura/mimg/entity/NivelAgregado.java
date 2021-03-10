package br.gov.prefeitura.mimg.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class NivelAgregado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "nivel_adm_id")
	private Nivel nivelAdmin;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nivel_especial_id")
	private Nivel nivelEspecial;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "nivel_ibge_id")
	private Nivel nivelIbge;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Agregado agregado;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Nivel getNivelAdmin() {
		return nivelAdmin;
	}
	public void setNivelAdmin(Nivel nivelAdmin) {
		this.nivelAdmin = nivelAdmin;
	}
	public Nivel getNivelEspecial() {
		return nivelEspecial;
	}
	public void setNivelEspecial(Nivel nivelEspecial) {
		this.nivelEspecial = nivelEspecial;
	}
	public Nivel getNivelIbge() {
		return nivelIbge;
	}
	public void setNivelIbge(Nivel nivelIbge) {
		this.nivelIbge = nivelIbge;
	}
	public Agregado getAgregado() {
		return agregado;
	}
	public void setAgregado(Agregado agregado) {
		this.agregado = agregado;
	}
}
