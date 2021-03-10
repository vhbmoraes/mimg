package br.gov.prefeitura.mimg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.prefeitura.mimg.entity.Agregado;
import br.gov.prefeitura.mimg.entity.Variavel;

public interface VariavelRepository extends JpaRepository<Variavel, Integer> {
	
	List<Variavel> findByAgregado(Agregado agregado);

}
