package br.gov.prefeitura.mimg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.prefeitura.mimg.entity.Agregado;
import br.gov.prefeitura.mimg.repository.AgregadoRepository;

@RestController
public class AgregadoController {
	
	@Autowired
	private AgregadoRepository agregadoRepository;
	
	@RequestMapping("/agregados")
	public List<AgregadoDto> retornar()
	{
		List<Agregado> agregados = agregadoRepository.findAll();
		return AgregadoDto.converter(agregados);
	}
	
	@RequestMapping("/agregado")
	public AgregadoDto retornar(Integer id)
	{
		Optional<Agregado> agregados = agregadoRepository.findById(id);
		return AgregadoDto.converter(agregados.get());
	}
}
