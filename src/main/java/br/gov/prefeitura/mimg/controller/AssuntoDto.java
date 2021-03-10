package br.gov.prefeitura.mimg.controller;

import java.util.List;
import java.util.stream.Collectors;

import br.gov.prefeitura.mimg.entity.Assunto;

public class AssuntoDto {
	
	private Integer id;
	private String descricao;
	
	public AssuntoDto(Assunto assunto)
	{
		id = assunto.getId();
		descricao = assunto.getDescricao();
	}
	
	public static List<AssuntoDto> converter(List<Assunto> assuntos)
	{
		return assuntos.stream().map(AssuntoDto::new).collect(Collectors.toList());
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
