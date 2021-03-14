package br.gov.prefeitura.mimg.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import br.gov.prefeitura.mimg.entity.Assunto;
import br.gov.prefeitura.mimg.entity.Classificacao;
import br.gov.prefeitura.mimg.entity.Nivel;
import br.gov.prefeitura.mimg.entity.Periodicidade;
import br.gov.prefeitura.mimg.entity.Pesquisa;
import br.gov.prefeitura.mimg.repository.AssuntoRepository;
import br.gov.prefeitura.mimg.repository.ClassificacaoRepository;
import br.gov.prefeitura.mimg.repository.NivelRepository;
import br.gov.prefeitura.mimg.repository.PeriodicidadeRepository;
import br.gov.prefeitura.mimg.repository.PesquisaRepository;
import br.gov.prefeitura.mimg.service.PesquisarAgregadoService;
import br.gov.prefeitura.mimg.util.DataUtil;

@Component
@RequestScope
public class Bean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private AssuntoRepository assuntoRepository;
	
	@Autowired
	private ClassificacaoRepository classificacaoRepository;
	
	@Autowired
	private PesquisaRepository pesquisaRepository;
	
	@Autowired
	private PeriodicidadeRepository periodicidadeRepository;
	
	@Autowired
	private NivelRepository nivelRepository;
	
	@Autowired
	private PesquisarAgregadoService pesquisarAgregadoService;

	private FiltroDto filtro;
	private List<Assunto> assuntos;
	private List<Classificacao> classificacoes;
	private List<Pesquisa> pesquisas;
	private List<Periodicidade> periodicidades;
	private List<Nivel> niveis;
	
	@PostConstruct
	public void iniciar()
	{
		filtro = new FiltroDto();
		assuntos = assuntoRepository.findAll();
		classificacoes = classificacaoRepository.findAll();
		pesquisas = pesquisaRepository.findAll();
		periodicidades = periodicidadeRepository.findAll();
		niveis = nivelRepository.findAll();
		filtro.setDescricaoVesaoCarga(pesquisarAgregadoService.retornaDescricaoVersaoCarga());
	}
	
	public void pesquisar()
	{
		Boolean retorno = pesquisarAgregadoService.cadastrar(filtro);	
		
		FacesContext context = FacesContext.getCurrentInstance();
		if (retorno == true)
			context.addMessage(null, new FacesMessage("Sucesso",  "Carga realizada") );
		else
			context.addMessage(null, new FacesMessage("Falhou",  "Pesquisa não retornou resultado") );
	}
	
	public void limpar()
	{
		filtro = new FiltroDto();
	}
	
	public List<String> pesquisarPorAssunto(String descricao)
	{
		assuntos = assuntoRepository.findByDescricaoContainingIgnoreCase(descricao);
		List<String> resultado = new ArrayList<String>();
		if (assuntos != null)
			for (Assunto a : assuntos) {
				resultado.add(a.getDescricao());
			}
		return resultado;
	}

	public FiltroDto getFiltro() {
		return filtro;
	}
	
	public void setFiltro(FiltroDto filtro) {
		this.filtro = filtro;
	}

	public List<Assunto> getAssuntos() {
		return assuntos;
	}

	public void setAssuntos(List<Assunto> assuntos) {
		this.assuntos = assuntos;
	}

	public List<Classificacao> getClassificacoes() {
		return classificacoes;
	}

	public void setClassificacoes(List<Classificacao> classificacoes) {
		this.classificacoes = classificacoes;
	}

	public List<Pesquisa> getPesquisas() {
		return pesquisas;
	}

	public void setPesquisas(List<Pesquisa> pesquisas) {
		this.pesquisas = pesquisas;
	}

	public List<Periodicidade> getPeriodicidades() {
		return periodicidades;
	}

	public void setPeriodicidades(List<Periodicidade> periodicidades) {
		this.periodicidades = periodicidades;
	}

	public List<Nivel> getNiveis() {
		return niveis;
	}

	public void setNiveis(List<Nivel> niveis) {
		this.niveis = niveis;
	}
}
