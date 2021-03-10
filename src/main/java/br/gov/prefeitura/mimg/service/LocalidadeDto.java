package br.gov.prefeitura.mimg.service;

import java.math.BigDecimal;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class LocalidadeDto {
	private String id;
	private String variavel;
	private String unidade;
	private List<Resultado> resultados;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVariavel() {
		return variavel;
	}

	public void setVariavel(String variavel) {
		this.variavel = variavel;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public List<Resultado> getResultados() {
		return resultados;
	}

	public void setResultados(List<Resultado> resultados) {
		this.resultados = resultados;
	}

	public static class Resultado
	{
		private List<Classificacao> classificacoes;
		private List<Series> series;
		
		public List<Classificacao> getClassificacoes() {
			return classificacoes;
		}
		public void setClassificacoes(List<Classificacao> classificacoes) {
			this.classificacoes = classificacoes;
		}
		public List<Series> getSeries() {
			return series;
		}
		public void setSeries(List<Series> series) {
			this.series = series;
		}
	}
	
	public static class Classificacao
	{
		private String id;
		private String nome;
		private Categoria categoria;
		
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
		public Categoria getCategoria() {
			return categoria;
		}
		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}
	}
	
	public static class Categoria
	{
		@SerializedName(value="descricao", alternate={"7087", "787"})
		private String descricao;

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
	}
	
	public static class Series
	{
		private Localidade localidade;
		private Serie serie;
		public Localidade getLocalidade() {
			return localidade;
		}
		public void setLocalidade(Localidade localidade) {
			this.localidade = localidade;
		}
		public Serie getSerie() {
			return serie;
		}
		public void setSerie(Serie serie) {
			this.serie = serie;
		}
	}
	
	public static class Localidade
	{
		private String id;
		private Nivel nivel;
		private String nome;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public Nivel getNivel() {
			return nivel;
		}
		public void setNivel(Nivel nivel) {
			this.nivel = nivel;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
	}
	
	public static class Nivel
	{
		private String id;
		private String nome;
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
	}
	
	public static class Serie
	{
		@SerializedName("202011")
		private BigDecimal valor;

		public BigDecimal getValor() {
			return valor;
		}

		public void setValor(BigDecimal valor) {
			this.valor = valor;
		}
	}
}
