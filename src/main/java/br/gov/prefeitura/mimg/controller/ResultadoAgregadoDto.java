package br.gov.prefeitura.mimg.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.gov.prefeitura.mimg.entity.ResultadoAgregado;

public class ResultadoAgregadoDto {
	
	private Integer idIbgeAgregado;
	private String nomeAgregado;
	private Integer idIbgeVariavel;
	private String nomeVariavel;
	private Integer idIbgeClassificacao;
	private String nomeClassificacao;
	private Integer idLocalidade;
	private String localidade;
	private String referenciaSerie;
	private BigDecimal valorSerie;
	private String idIbgeNivel;
	private String nomeNivel;
	
	public ResultadoAgregadoDto(ResultadoAgregado r)
	{
		idIbgeAgregado = r.getAgregado().getIdIbgeAgregado();
		nomeAgregado = r.getAgregado().getNome();
		idIbgeVariavel = r.getVariavel().getIdIbgeVariavel();
		nomeVariavel = r.getVariavel().getNome();
		idIbgeClassificacao = r.getClassificacaoAgregado().getClassificacao().getIdIbgeClassificacao();
		nomeClassificacao = r.getClassificacaoAgregado().getNome();
		idLocalidade = r.getLocalidade().getId();
		localidade = r.getLocalidade().getDescricao();
		idIbgeNivel = r.getLocalidade().getNivel().getIdIbgeNivel();
		nomeNivel = r.getLocalidade().getNivel().getDescricao();
		referenciaSerie = r.getReferenciaSerie();
		valorSerie = r.getValorSerie();
	}
	
	public static List<ResultadoAgregadoDto> converter(List<ResultadoAgregado> agregados)
	{
		return agregados.stream().map(ResultadoAgregadoDto::new).collect(Collectors.toList());
	}
	
	public static ResultadoAgregadoDto converter(ResultadoAgregado agregado)
	{
		return new ResultadoAgregadoDto(agregado);
	}

	public Integer getIdIbgeAgregado() {
		return idIbgeAgregado;
	}

	public void setIdIbgeAgregado(Integer idIbgeAgregado) {
		this.idIbgeAgregado = idIbgeAgregado;
	}

	public String getNomeAgregado() {
		return nomeAgregado;
	}

	public void setNomeAgregado(String nomeAgregado) {
		this.nomeAgregado = nomeAgregado;
	}

	public Integer getIdIbgeVariavel() {
		return idIbgeVariavel;
	}

	public void setIdIbgeVariavel(Integer idIbgeVariavel) {
		this.idIbgeVariavel = idIbgeVariavel;
	}

	public String getNomeVariavel() {
		return nomeVariavel;
	}

	public void setNomeVariavel(String nomeVariavel) {
		this.nomeVariavel = nomeVariavel;
	}

	public Integer getIdIbgeClassificacao() {
		return idIbgeClassificacao;
	}

	public void setIdIbgeClassificacao(Integer idIbgeClassificacao) {
		this.idIbgeClassificacao = idIbgeClassificacao;
	}

	public String getNomeClassificacao() {
		return nomeClassificacao;
	}

	public void setNomeClassificacao(String nomeClassificacao) {
		this.nomeClassificacao = nomeClassificacao;
	}

	public Integer getIdLocalidade() {
		return idLocalidade;
	}

	public void setIdLocalidade(Integer idLocalidade) {
		this.idLocalidade = idLocalidade;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getReferenciaSerie() {
		return referenciaSerie;
	}

	public void setReferenciaSerie(String referenciaSerie) {
		this.referenciaSerie = referenciaSerie;
	}

	public BigDecimal getValorSerie() {
		return valorSerie;
	}

	public void setValorSerie(BigDecimal valorSerie) {
		this.valorSerie = valorSerie;
	}

	public String getIdIbgeNivel() {
		return idIbgeNivel;
	}

	public void setIdIbgeNivel(String idIbgeNivel) {
		this.idIbgeNivel = idIbgeNivel;
	}

	public String getNomeNivel() {
		return nomeNivel;
	}

	public void setNomeNivel(String nomeNivel) {
		this.nomeNivel = nomeNivel;
	}
}
