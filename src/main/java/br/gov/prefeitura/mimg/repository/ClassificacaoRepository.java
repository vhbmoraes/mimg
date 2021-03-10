package br.gov.prefeitura.mimg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.prefeitura.mimg.entity.Classificacao;

public interface ClassificacaoRepository extends JpaRepository<Classificacao, Integer> {
	
	Classificacao findByIdIbgeClassificacao(Integer idIbgeClassificacao);

}
