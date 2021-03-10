package br.gov.prefeitura.mimg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.prefeitura.mimg.entity.Periodicidade;
import br.gov.prefeitura.mimg.repository.PeriodicidadeRepository;

@RestController
public class PeriodicidadeController {
	
	@Autowired
	private PeriodicidadeRepository periodicidadeRepository;
	
	@RequestMapping("/periodicidade")
	public List<PeriodicidadeDto> retornar()
	{
		List<Periodicidade> periodicidades = periodicidadeRepository.findAll();
		return PeriodicidadeDto.converter(periodicidades);
	}

}
