package br.gov.prefeitura.mimg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.prefeitura.mimg.entity.Pesquisa;

public interface PesquisaRepository extends JpaRepository<Pesquisa, Integer> {

	Pesquisa findByIdIbgePesquisa(String id);

}
