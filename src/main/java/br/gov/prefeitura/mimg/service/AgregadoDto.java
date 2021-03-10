package br.gov.prefeitura.mimg.service;

import java.util.List;

public class AgregadoDto {
	private String id;
	private String nome;
	private List<Agregados> agregados;
	
	public String getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public List<Agregados> getAgregados() {
		return agregados;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setAgregados(List<Agregados> agregados) {
		this.agregados = agregados;
	}
	
	public static class Agregados
	{
		private String id;
		private String nome;
		
		public String getId() {
			return id;
		}
		
		public String getNome() {
			return nome;
		}
		
		public void setId(String id) {
			this.id = id;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
	}
}
