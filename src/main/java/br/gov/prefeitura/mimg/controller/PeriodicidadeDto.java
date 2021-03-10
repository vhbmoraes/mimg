package br.gov.prefeitura.mimg.controller;

import java.util.List;
import java.util.stream.Collectors;

import br.gov.prefeitura.mimg.entity.Periodicidade;

public class PeriodicidadeDto {
	
	private Integer id;
	private String descricao;
	
	public PeriodicidadeDto(Periodicidade periodicidade)
	{
		id = periodicidade.getId();
		descricao = periodicidade.getDescricao();
	}
	
	public static List<PeriodicidadeDto> converter(List<Periodicidade> periodicidades)
	{
		return periodicidades.stream().map(PeriodicidadeDto::new).collect(Collectors.toList());
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
