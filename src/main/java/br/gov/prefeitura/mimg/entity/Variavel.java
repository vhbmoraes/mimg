package br.gov.prefeitura.mimg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Variavel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
    private String unidade;
    @ManyToOne(fetch = FetchType.LAZY)
    private Agregado agregado;
    @Column(name = "id_ibge_variavel")
    private Integer idIbgeVariavel;
    
    
    
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
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public Agregado getAgregado() {
		return agregado;
	}
	public void setAgregado(Agregado agregado) {
		this.agregado = agregado;
	}
	public Integer getIdIbgeVariavel() {
		return idIbgeVariavel;
	}
	public void setIdIbgeVariavel(Integer idIbgeVariavel) {
		this.idIbgeVariavel = idIbgeVariavel;
	}
}
