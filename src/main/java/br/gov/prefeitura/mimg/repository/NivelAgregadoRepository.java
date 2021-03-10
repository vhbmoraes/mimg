package br.gov.prefeitura.mimg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.prefeitura.mimg.entity.Agregado;
import br.gov.prefeitura.mimg.entity.NivelAgregado;

public interface NivelAgregadoRepository extends JpaRepository<NivelAgregado, Integer> {
	
	List<NivelAgregado> findByAgregado(Agregado agregado);	

}
