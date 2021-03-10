package br.gov.prefeitura.mimg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne(fetch = FetchType.LAZY)
	private ClassificacaoAgregado classificacaoAgregado;
	private String unidade;
	private Integer nivel;
	@Column(name = "id_ibge_categoria")
	private Integer idIbgeCategoria;
    private String nome;
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ClassificacaoAgregado getClassificacaoAgregado() {
		return classificacaoAgregado;
	}
	public void setClassificacaoAgregado(ClassificacaoAgregado classificacaoAgregado) {
		this.classificacaoAgregado = classificacaoAgregado;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public Integer getNivel() {
		return nivel;
	}
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	public Integer getIdIbgeCategoria() {
		return idIbgeCategoria;
	}
	public void setIdIbgeCategoria(Integer idIbgeCategoria) {
		this.idIbgeCategoria = idIbgeCategoria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
