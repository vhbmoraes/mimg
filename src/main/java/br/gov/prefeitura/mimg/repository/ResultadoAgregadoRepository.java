package br.gov.prefeitura.mimg.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.prefeitura.mimg.entity.ResultadoAgregado;

public interface ResultadoAgregadoRepository extends JpaRepository<ResultadoAgregado, Integer> {
	
	List<ResultadoAgregado> findByAgregadoIdIbgeAgregado(Integer idIbgeAgregado);
	
	List<ResultadoAgregado> findTopByAgregadoIdIbgeAgregadoOrderByIdDesc(Integer idIbgeAgregado);
	
	Optional<ResultadoAgregado> findById(Integer id);

}
