package br.gov.prefeitura.mimg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.prefeitura.mimg.entity.Nivel;

public interface NivelRepository extends JpaRepository<Nivel, Integer> {
	
	Nivel findByIdIbgeNivelContainingIgnoreCase(String idIbgeNivel);	

}
