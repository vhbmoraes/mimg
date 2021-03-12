package br.gov.prefeitura.mimg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.prefeitura.mimg.entity.ResultadoAgregado;
import br.gov.prefeitura.mimg.repository.ResultadoAgregadoRepository;

@RestController
public class ResultadoAgregadoController {

	@Autowired
	private ResultadoAgregadoRepository resultadoAgregadoRepository;

	@RequestMapping("/resultadoAgregado")
	public List<ResultadoAgregadoDto> resultado(Integer agregado) {
		List<ResultadoAgregado> ra = resultadoAgregadoRepository.findByAgregadoIdIbgeAgregado(agregado);

		return ResultadoAgregadoDto.converter(ra);
	}
}
