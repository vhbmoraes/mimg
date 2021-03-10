package br.gov.prefeitura.mimg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.prefeitura.mimg.entity.Agregado;
import br.gov.prefeitura.mimg.entity.PeriodicidadeAgregado;

public interface PeriodicidadeAgregadoRepository extends JpaRepository<PeriodicidadeAgregado, Integer> {
	
	PeriodicidadeAgregado findByAgregado(Agregado agregado);
	

}
