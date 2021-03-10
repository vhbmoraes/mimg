package br.gov.prefeitura.mimg.controller;

import java.util.List;
import java.util.stream.Collectors;

import br.gov.prefeitura.mimg.entity.Agregado;

public class AgregadoDto {
	
	private String pesquisa;
	private String nome;
	private String urlAgregado;
	private String assunto;
	private Integer idIbgeAgragado;
	private String versaoCarga;
	
	public AgregadoDto(Agregado agregado)
	{
		nome = agregado.getNome();
		urlAgregado = agregado.getUrlAgregado();
		idIbgeAgragado = agregado.getIdIbgeAgregado();
		pesquisa = agregado.getPesquisa().getNome();
		assunto = agregado.getAssunto().getDescricao();
		versaoCarga = agregado.getVersaoCarga().getDescricao();
	}
	
	public static List<AgregadoDto> converter(List<Agregado> agregados)
	{
		return agregados.stream().map(AgregadoDto::new).collect(Collectors.toList());
	}
	
	public static AgregadoDto converter(Agregado agregado)
	{
		return new AgregadoDto(agregado);
	}
	
	public String getNome() {
		return nome;
	}
	public String getUrlAgregado() {
		return urlAgregado;
	}	
	public Integer getIdIbgeAgragado() {
		return idIbgeAgragado;
	}
	public String getAssunto() {
		return assunto;
	}
	public String getPesquisa() {
		return pesquisa;
	}
	public String getVersaoCarga() {
		return versaoCarga;
	}
}
