package br.gov.prefeitura.mimg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.prefeitura.mimg.entity.Classificacao;
import br.gov.prefeitura.mimg.repository.ClassificacaoRepository;

@RestController
public class ClassificacaoController {
	
	@Autowired
	private ClassificacaoRepository classificacaoRepository;
	
	@RequestMapping("/classificacao")
	public List<ClassificacaoDto> retornar()
	{
		List<Classificacao> classificacoes = classificacaoRepository.findAll();
		return ClassificacaoDto.converter(classificacoes);
	}

}
