package br.gov.prefeitura.mimg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.prefeitura.mimg.entity.Localidade;
import br.gov.prefeitura.mimg.entity.Nivel;

public interface LocalidadeRepository extends JpaRepository<Localidade, Integer> {

	List<Localidade> findByNivel(Nivel nivel) ;
	
}
