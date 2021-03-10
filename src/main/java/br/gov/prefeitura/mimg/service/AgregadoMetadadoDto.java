package br.gov.prefeitura.mimg.service;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class AgregadoMetadadoDto {
	private String id;
	private String nome;
	private String URL;
	private String pesquisa;
	private String assunto;
	private Periodicidade periodicidade;
	private NivelTerritorial nivelTerritorial;
	private List<Variavel> variaveis;
	private List<Classificacao> classificacoes;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getPesquisa() {
		return pesquisa;
	}
	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public Periodicidade getPeriodicidade() {
		return periodicidade;
	}
	public void setPeriodicidade(Periodicidade periodicidade) {
		this.periodicidade = periodicidade;
	}
	public NivelTerritorial getNivelTerritorial() {
		return nivelTerritorial;
	}
	public void setNivelTerritorial(NivelTerritorial nivelTerritorial) {
		this.nivelTerritorial = nivelTerritorial;
	}
	public List<Variavel> getVariaveis() {
		return variaveis;
	}
	public void setVariaveis(List<Variavel> variaveis) {
		this.variaveis = variaveis;
	}
	public List<Classificacao> getClassificacoes() {
		return classificacoes;
	}
	public void setClassificacoes(List<Classificacao> classificacoes) {
		this.classificacoes = classificacoes;
	}

	public static class Periodicidade
	{
		private String frequencia;
		private String inicio;
		private String fim;
		
		public String getFrequencia() {
			return frequencia;
		}
		public void setFrequencia(String frequencia) {
			this.frequencia = frequencia;
		}
		public String getInicio() {
			return inicio;
		}
		public void setInicio(String inicio) {
			this.inicio = inicio;
		}
		public String getFim() {
			return fim;
		}
		public void setFim(String fim) {
			this.fim = fim;
		}
	}
	
	public static class NivelTerritorial
	{
		@SerializedName("Administrativo")
		private List<String> administrativo;
		@SerializedName("Especial")
		private List<String> especial;
		@SerializedName("IBGE")
		private List<String> ibge;
		
		public List<String> getAdministrativo() {
			return administrativo;
		}
		public void setAdministrativo(List<String> administrativo) {
			this.administrativo = administrativo;
		}
		public List<String> getEspecial() {
			return especial;
		}
		public void setEspecial(List<String> especial) {
			this.especial = especial;
		}
		public List<String> getIbge() {
			return ibge;
		}
		public void setIbge(List<String> ibge) {
			this.ibge = ibge;
		}
	}
	
	public static class Variavel
	{
		private String id;
		private String nome;
		private String unidade;
		private List<String> sumarizacao;
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
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
		public List<String> getSumarizacao() {
			return sumarizacao;
		}
		public void setSumarizacao(List<String> sumarizacao) {
			this.sumarizacao = sumarizacao;
		}
	}
	
	public static class Classificacao
	{
		private String id;
		private String nome;
		private Sumarizacao sumarizacao;
		private List<Categoria> categorias;
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public Sumarizacao getSumarizacao() {
			return sumarizacao;
		}
		public void setSumarizacao(Sumarizacao sumarizacao) {
			this.sumarizacao = sumarizacao;
		}
		public List<Categoria> getCategorias() {
			return categorias;
		}
		public void setCategorias(List<Categoria> categorias) {
			this.categorias = categorias;
		}
	}
	
	public static class Sumarizacao
	{
		private Boolean status;
		private List<String> excecao;
		
		public Boolean getStatus() {
			return status;
		}
		public void setStatus(Boolean status) {
			this.status = status;
		}
		public List<String> getExcecao() {
			return excecao;
		}
		public void setExcecao(List<String> excecao) {
			this.excecao = excecao;
		}
	}
	
	public static class Categoria
	{
		private Integer id;
		private String nome;
		private String unidade;
		private Integer nivel;
		
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
		public Integer getNivel() {
			return nivel;
		}
		public void setNivel(Integer nivel) {
			this.nivel = nivel;
		} 
	}
}