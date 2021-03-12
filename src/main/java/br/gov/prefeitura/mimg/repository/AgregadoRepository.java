package br.gov.prefeitura.mimg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.prefeitura.mimg.entity.Agregado;
import br.gov.prefeitura.mimg.entity.VersaoCarga;

public interface AgregadoRepository extends JpaRepository<Agregado, Integer> {
	
	List<Agregado> findByVersaoCarga(VersaoCarga versaoCarga);
	
	Agregado findTop1ByIdIbgeAgregadoOrderByIdDesc(Integer idIbgeAgregado);

}
