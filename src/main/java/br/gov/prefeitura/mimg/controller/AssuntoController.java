package br.gov.prefeitura.mimg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.prefeitura.mimg.entity.Assunto;
import br.gov.prefeitura.mimg.repository.AssuntoRepository;

@RestController
public class AssuntoController {
	
	@Autowired
	private AssuntoRepository assuntoRepository;
	
	@RequestMapping("/assunto")
	public List<AssuntoDto> retornar()
	{
		List<Assunto> assuntos = assuntoRepository.findAll();
		return AssuntoDto.converter(assuntos);
	}
}
