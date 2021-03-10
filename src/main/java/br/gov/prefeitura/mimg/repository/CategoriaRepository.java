package br.gov.prefeitura.mimg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.prefeitura.mimg.entity.Categoria;
import br.gov.prefeitura.mimg.entity.ClassificacaoAgregado;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	
	Categoria findByIdIbgeCategoria(Integer idIbgeCategoria);
	
	List<Categoria> findByClassificacaoAgregado(ClassificacaoAgregado classificacaoAgregado);
	
}
