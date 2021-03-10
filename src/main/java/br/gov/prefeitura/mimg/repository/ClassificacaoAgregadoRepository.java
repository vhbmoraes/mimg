package br.gov.prefeitura.mimg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.prefeitura.mimg.entity.Agregado;
import br.gov.prefeitura.mimg.entity.ClassificacaoAgregado;

public interface ClassificacaoAgregadoRepository extends JpaRepository<ClassificacaoAgregado, Integer> {

	List<ClassificacaoAgregado> findByAgregado(Agregado agregado);
	
}
