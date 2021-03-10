package br.gov.prefeitura.mimg.bean;

import br.gov.prefeitura.mimg.entity.Assunto;
import br.gov.prefeitura.mimg.entity.Classificacao;
import br.gov.prefeitura.mimg.entity.Nivel;
import br.gov.prefeitura.mimg.entity.Periodicidade;
import br.gov.prefeitura.mimg.entity.Pesquisa;

public class FiltroDto {

	private String descricaoVesaoCarga;
	private Assunto assunto;
	private Classificacao classificacao;
	private Pesquisa pesquisa;
	private Periodicidade periodicidade;
	private Nivel nivel;

	public String getDescricaoVesaoCarga() {
		return descricaoVesaoCarga;
	}

	public void setDescricaoVesaoCarga(String descricaoVesaoCarga) {
		this.descricaoVesaoCarga = descricaoVesaoCarga;
	}

	public Assunto getAssunto() { 
		return assunto; 
	}
	  
	public void setAssunto(Assunto assunto) { 
		this.assunto = assunto; 
	}

	public Classificacao getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}

	public Pesquisa getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(Pesquisa pesquisa) {
		this.pesquisa = pesquisa;
	}

	public Periodicidade getPeriodicidade() {
		return periodicidade;
	}

	public void setPeriodicidade(Periodicidade periodicidade) {
		this.periodicidade = periodicidade;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
}
