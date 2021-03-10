package br.gov.prefeitura.mimg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.prefeitura.mimg.entity.Nivel;
import br.gov.prefeitura.mimg.repository.NivelRepository;

@RestController
public class NivelController {
	
	@Autowired
	private NivelRepository nivelRepository;
	
	@RequestMapping("/nivel")
	public List<NivelDto> retornar()
	{
		List<Nivel> niveis = nivelRepository.findAll();
		return NivelDto.converter(niveis);
	}

}
