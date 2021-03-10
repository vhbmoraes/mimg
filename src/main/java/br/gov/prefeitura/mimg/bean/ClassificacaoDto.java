package br.gov.prefeitura.mimg.bean;

import br.gov.prefeitura.mimg.entity.Categoria;
import br.gov.prefeitura.mimg.entity.ClassificacaoAgregado;

public class ClassificacaoDto {

	private ClassificacaoAgregado classificacaoAgregado;
	private Categoria categoria;
	
	public ClassificacaoAgregado getClassificacaoAgregado() {
		return classificacaoAgregado;
	}
	public void setClassificacaoAgregado(ClassificacaoAgregado classificacaoAgregado) {
		this.classificacaoAgregado = classificacaoAgregado;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}