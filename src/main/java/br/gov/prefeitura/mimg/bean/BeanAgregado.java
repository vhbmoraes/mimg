package br.gov.prefeitura.mimg.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.gov.prefeitura.mimg.entity.Agregado;
import br.gov.prefeitura.mimg.entity.Categoria;
import br.gov.prefeitura.mimg.entity.ClassificacaoAgregado;
import br.gov.prefeitura.mimg.entity.Localidade;
import br.gov.prefeitura.mimg.entity.NivelAgregado;
import br.gov.prefeitura.mimg.entity.PeriodicidadeAgregado;
import br.gov.prefeitura.mimg.entity.Variavel;
import br.gov.prefeitura.mimg.entity.VersaoCarga;
import br.gov.prefeitura.mimg.repository.AgregadoRepository;
import br.gov.prefeitura.mimg.repository.CategoriaRepository;
import br.gov.prefeitura.mimg.repository.ClassificacaoAgregadoRepository;
import br.gov.prefeitura.mimg.repository.LocalidadeRepository;
import br.gov.prefeitura.mimg.repository.NivelAgregadoRepository;
import br.gov.prefeitura.mimg.repository.PeriodicidadeAgregadoRepository;
import br.gov.prefeitura.mimg.repository.VariavelRepository;
import br.gov.prefeitura.mimg.repository.VersaoCargaRepository;
import br.gov.prefeitura.mimg.service.CadastrarResultadoAgregadoService;

@Component
@SessionScoped
public class BeanAgregado implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Value("${app.url.sgm}")
	private String urlSgm;

	@Autowired
	private VersaoCargaRepository versaoCargaRepository;
	
	@Autowired
	private AgregadoRepository agregadoRepository;
	
	@Autowired
	private PeriodicidadeAgregadoRepository periodicidadeAgregadoRepository;
	
	@Autowired
	private VariavelRepository variavelRepository;
	
	@Autowired
	private NivelAgregadoRepository nivelAgregadoRepository;
	
	@Autowired
	private LocalidadeRepository localidadeRepository;
	
	@Autowired
	private ClassificacaoAgregadoRepository classificacaoAgregadoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private CadastrarResultadoAgregadoService cadastrarResultadoAgregadoService;

	private Integer versaoCargaId;
	private List<VersaoCarga> versoesCarga;
	private Integer agregadoId;
	private List<Agregado> agregados;
	private String periodo;
	private String periodoExemplo;
	private Integer variavelId;
	private List<Variavel> variaveis;
	private Integer nivelId;
	private List<NivelAgregado> niveis;
	private Integer localidadeId;
	private List<Localidade> localidades;
	private Integer classificacaoAgregadoId;
	private List<ClassificacaoAgregado> classificacoesAgregado;
	private Integer categoriaId;
	private List<Categoria> categorias;
	private List<ClassificacaoDto> classificacoes;
	
	@PostConstruct
	public void iniciar()
	{
		versoesCarga = versaoCargaRepository.findAll();
		classificacoes = new ArrayList<>();
		periodoExemplo = "Ex. AAAAMM";
	}
	
	public void cadastrar()
	{
		Boolean retorno = cadastrarResultadoAgregadoService.cadastrar(agregadoId, periodo, variavelId, localidadeId, classificacoes);
		
		FacesContext context = FacesContext.getCurrentInstance();
		if (retorno == true)
			context.addMessage(null, new FacesMessage("Sucesso",  "Carga realizada") );
		else
			context.addMessage(null, new FacesMessage("Falhou",  "Pesquisa não retornou resultado") );
	}
	
	public void limpar()
	{
		versaoCargaId = null;
		agregadoId = null;
		agregados = new ArrayList<>();
		periodo = null;
		periodoExemplo = "Ex. AAAAMM";
		variavelId = null;
		variaveis = new ArrayList<>();
		nivelId = null;
		niveis = new ArrayList<>();
		localidadeId = null;
		localidades = new ArrayList<>();
		classificacaoAgregadoId = null;
		classificacoesAgregado = new ArrayList<>();
		categoriaId = null;
		categorias = new ArrayList<>();
		classificacoes = new ArrayList<>();
		versoesCarga = versaoCargaRepository.findAll();
	}
	
	public void pesquisarAgregado()
	{
		Optional<VersaoCarga> versaoCarga = versaoCargaRepository.findById(versaoCargaId);
		agregados = agregadoRepository.findByVersaoCarga(versaoCarga.get());
	}
	
	public void pesquisarDependencia()
	{
		Optional<Agregado> a = agregadoRepository.findById(agregadoId);
		PeriodicidadeAgregado p = periodicidadeAgregadoRepository.findByAgregado(a.get());
		periodoExemplo = "Informe um período entre '" + p.getInicio() + "' a '" + p.getFim() + "'.";
		
		variaveis = variavelRepository.findByAgregado(a.get());
		niveis = nivelAgregadoRepository.findByAgregado(a.get());
		classificacoesAgregado = classificacaoAgregadoRepository.findByAgregado(a.get());
		System.out.println();
	}
	
	public void pesquisarLocalidade()
	{
		Optional<NivelAgregado> na = nivelAgregadoRepository.findById(nivelId);
		localidades = localidadeRepository.findByNivel(na.get().getNivelAdmin());
	}
	
	public void pesquisarCategoria()
	{
		Optional<ClassificacaoAgregado> classificacaoAgregado = classificacaoAgregadoRepository.findById(classificacaoAgregadoId);
		categorias = categoriaRepository.findByClassificacaoAgregado(classificacaoAgregado.get());
	}
	
	public void limparClassificacao()
	{
		classificacaoAgregadoId = null;
		categoriaId = null;
		categorias = new ArrayList<>();
	}
	
	public void adicionar()
	{
		ClassificacaoDto dto = new ClassificacaoDto();
		if (classificacaoAgregadoId != null && categoriaId != null)
		{
			Optional<ClassificacaoAgregado> classificacaoAgregado = classificacaoAgregadoRepository.findById(classificacaoAgregadoId);
			dto.setClassificacaoAgregado(classificacaoAgregado.get());
			Optional<Categoria> categoria = categoriaRepository.findById(categoriaId);
			dto.setCategoria(categoria.get());
			classificacoes.add(dto);
		}
	}
	
	public void remover(int index)
	{
		classificacoes.remove(index);
	}

	
	public Integer getVersaoCargaId() {
		return versaoCargaId;
	}
	public void setVersaoCargaId(Integer versaoCargaId) {
		this.versaoCargaId = versaoCargaId;
	}
	public List<VersaoCarga> getVersoesCarga() {
		return versoesCarga;
	}
	public String getUrlSgm() {
		return urlSgm;
	}
	public List<Agregado> getAgregados() {
		return agregados;
	}
	public Integer getAgregadoId() {
		return agregadoId;
	}
	public void setAgregadoId(Integer agregadoId) {
		this.agregadoId = agregadoId;
	}
	public Integer getVariavelId() {
		return variavelId;
	}
	public void setVariavelId(Integer variavelId) {
		this.variavelId = variavelId;
	}
	public List<Variavel> getVariaveis() {
		return variaveis;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public Integer getNivelId() {
		return nivelId;
	}
	public void setNivelId(Integer nivelId) {
		this.nivelId = nivelId;
	}
	public List<NivelAgregado> getNiveis() {
		return niveis;
	}
	public String getPeriodoExemplo() {
		return periodoExemplo;
	}
	public List<ClassificacaoAgregado> getClassificacoesAgregado() {
		return classificacoesAgregado;
	}
	public Integer getClassificacaoAgregadoId() {
		return classificacaoAgregadoId;
	}
	public void setClassificacaoAgregadoId(Integer classificacaoAgregadoId) {
		this.classificacaoAgregadoId = classificacaoAgregadoId;
	}
	public Integer getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public Integer getLocalidadeId() {
		return localidadeId;
	}
	public void setLocalidadeId(Integer localidadeId) {
		this.localidadeId = localidadeId;
	}
	public List<Localidade> getLocalidades() {
		return localidades;
	}
	public List<ClassificacaoDto> getClassificacoes() {
		return classificacoes;
	}
}