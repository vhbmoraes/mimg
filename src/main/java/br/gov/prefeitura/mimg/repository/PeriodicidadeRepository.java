package br.gov.prefeitura.mimg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.prefeitura.mimg.entity.Periodicidade;

public interface PeriodicidadeRepository extends JpaRepository<Periodicidade, Integer> {
	
	Periodicidade findByDescricaoContainingIgnoreCase(String descricao);

}
