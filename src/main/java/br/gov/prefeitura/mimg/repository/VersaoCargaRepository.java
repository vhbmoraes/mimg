package br.gov.prefeitura.mimg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.prefeitura.mimg.entity.VersaoCarga;

public interface VersaoCargaRepository extends JpaRepository<VersaoCarga, Integer> {
	
	VersaoCarga	findTopByOrderByIdDesc();
	
}