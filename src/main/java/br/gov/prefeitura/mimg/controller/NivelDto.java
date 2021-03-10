package br.gov.prefeitura.mimg.controller;

import java.util.List;
import java.util.stream.Collectors;

import br.gov.prefeitura.mimg.entity.Nivel;

public class NivelDto {
	
	private Integer id;
	private String descricao;
	
	public NivelDto(Nivel nivel)
	{
		id = nivel.getId();
		descricao = nivel.getDescricao();
	}
	
	public static List<NivelDto> converter(List<Nivel> niveis)
	{
		return niveis.stream().map(NivelDto::new).collect(Collectors.toList());
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
