package br.gov.prefeitura.mimg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.prefeitura.mimg.entity.Assunto;

public interface AssuntoRepository extends JpaRepository<Assunto, Integer> {
	
	//@Query(" select descricao from Assunto where descricao ilike :descricao ")
	List<Assunto> findByDescricaoContainingIgnoreCase(String descricao);
	
	Assunto findByDescricao(String descricao);

}
