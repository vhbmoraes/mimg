package br.gov.prefeitura.mimg.controller;

import java.util.List;
import java.util.stream.Collectors;

import br.gov.prefeitura.mimg.entity.Classificacao;

public class ClassificacaoDto {
	
	private Integer id;
	private String descricao;
	
	public ClassificacaoDto(Classificacao classificacao)
	{
		id = classificacao.getId();
		descricao = classificacao.getDescricao();
	}
	
	public static List<ClassificacaoDto> converter(List<Classificacao> classificacoes)
	{
		return classificacoes.stream().map(ClassificacaoDto::new).collect(Collectors.toList());
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
