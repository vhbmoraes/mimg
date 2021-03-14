package br.gov.prefeitura.mimg.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.gov.prefeitura.mimg.bean.FiltroDto;
import br.gov.prefeitura.mimg.entity.Agregado;
import br.gov.prefeitura.mimg.entity.Assunto;
import br.gov.prefeitura.mimg.entity.Categoria;
import br.gov.prefeitura.mimg.entity.Classificacao;
import br.gov.prefeitura.mimg.entity.ClassificacaoAgregado;
import br.gov.prefeitura.mimg.entity.Nivel;
import br.gov.prefeitura.mimg.entity.NivelAgregado;
import br.gov.prefeitura.mimg.entity.Periodicidade;
import br.gov.prefeitura.mimg.entity.PeriodicidadeAgregado;
import br.gov.prefeitura.mimg.entity.Pesquisa;
import br.gov.prefeitura.mimg.entity.SumarizacaoClassificacao;
import br.gov.prefeitura.mimg.entity.Variavel;
import br.gov.prefeitura.mimg.entity.VersaoCarga;
import br.gov.prefeitura.mimg.repository.AgregadoRepository;
import br.gov.prefeitura.mimg.repository.AssuntoRepository;
import br.gov.prefeitura.mimg.repository.CategoriaRepository;
import br.gov.prefeitura.mimg.repository.ClassificacaoAgregadoRepository;
import br.gov.prefeitura.mimg.repository.ClassificacaoRepository;
import br.gov.prefeitura.mimg.repository.NivelAgregadoRepository;
import br.gov.prefeitura.mimg.repository.NivelRepository;
import br.gov.prefeitura.mimg.repository.PeriodicidadeAgregadoRepository;
import br.gov.prefeitura.mimg.repository.PeriodicidadeRepository;
import br.gov.prefeitura.mimg.repository.PesquisaRepository;
import br.gov.prefeitura.mimg.repository.SumarizacaoClassificacaoRepository;
import br.gov.prefeitura.mimg.repository.VariavelRepository;
import br.gov.prefeitura.mimg.repository.VersaoCargaRepository;
import br.gov.prefeitura.mimg.service.AgregadoDto.Agregados;
import br.gov.prefeitura.mimg.util.DataUtil;

@Service
public class PesquisarAgregadoService {

	@Autowired
	private PesquisaRepository pesquisaRepository;
	
	@Autowired
	private AssuntoRepository assuntoRepository;
	
	@Autowired
	private AgregadoRepository agregadoRepository;

	@Autowired
	private VersaoCargaRepository versaoCargaRepository;
	
	@Autowired
	private PeriodicidadeAgregadoRepository periodicidadeAgregadoRepository;
	
	@Autowired
	private PeriodicidadeRepository periodicidadeRepository;
	
	@Autowired
	private NivelRepository nivelRepository;
	
	@Autowired
	private NivelAgregadoRepository nivelAgregadoRepository;
	
	@Autowired
	private VariavelRepository variavelRepository;
	
	@Autowired
	private ClassificacaoRepository classificacaoRepository;
	
	@Autowired
	private ClassificacaoAgregadoRepository classificacaoAgregadoRepository;
	
	@Autowired
	private SumarizacaoClassificacaoRepository sumarizacaoClassificacaoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Value("${app.url.ibge}")
	private String urlIbge;

	public List<AgregadoDto> pesquisarAgregados(FiltroDto filtro) {
		try {
			String url = retornarUrl(filtro);

			System.out.println(url);

			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");

			if (conn.getResponseCode() != 200) {
				System.out.println("Erro " + conn.getResponseCode() + " ao obter dados da URL " + url);
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream()), "UTF-8"));

			String output = "";
			String line;
			while ((line = br.readLine()) != null) {
				output += line;
			}

			conn.disconnect();

			Gson gson = new Gson();

			AgregadoDto[] dto = gson.fromJson(new String(output.getBytes()), AgregadoDto[].class);
			List<AgregadoDto> agregados = new ArrayList<AgregadoDto>();
			for (AgregadoDto a : dto) {
				agregados.add(a);
			}
			return agregados;

		} catch (IOException ex) {
			ex.getMessage();
		}
		return null;
	}
	
	public AgregadoMetadadoDto obterAgregadosMetadados(String idIbgeAgragado) {
		try {
			String url = urlIbge + "/" + idIbgeAgragado + "/metadados";

			System.out.println(url);

			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");

			if (conn.getResponseCode() != 200) {
				System.out.println("Erro " + conn.getResponseCode() + " ao obter dados da URL " + url);
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream()), "UTF-8"));

			String output = "";
			String line;
			while ((line = br.readLine()) != null) {
				output += line;
			}

			conn.disconnect();

			Gson gson = new Gson();

			AgregadoMetadadoDto dto = gson.fromJson(new String(output.getBytes()), AgregadoMetadadoDto.class);
			return dto;

		} catch (IOException ex) {
			ex.getMessage();
		}
		return null;
	}

	public String retornarUrl(FiltroDto filtro) {
		return urlIbge + "?" + montarFiltro(filtro);
	}

	private String montarFiltro(FiltroDto filtro) {
		String retorno = "";
		if (filtro.getPeriodicidade() != null) {
			retorno = "periodicidade=" + filtro.getPeriodicidade().getIdIbgePeriodicidade();
		}

		if (filtro.getAssunto() != null) {
			retorno = add(retorno) + "assunto=" + filtro.getAssunto().getId();
		}

		if (filtro.getClassificacao() != null) {
			retorno = add(retorno) + "classificacao=" + filtro.getClassificacao().getIdIbgeClassificacao();
		}

		if (filtro.getNivel() != null) {
			retorno = add(retorno) + "nivel=" + filtro.getNivel().getIdIbgeNivel();
		}
		return retorno;
	}

	private String add(String valor) {
		if (!valor.equals(""))
			return valor + "&";

		return "";
	}

	@Transactional
	public Boolean cadastrar(FiltroDto filtro) {
		boolean retorno = false;
		List<AgregadoDto> agregados = pesquisarAgregados(filtro);

		VersaoCarga versaoCarga = new VersaoCarga();
		versaoCarga.setDescricao(filtro.getDescricaoVesaoCarga());
		versaoCarga.setDataVersao(new Date());
		versaoCargaRepository.save(versaoCarga);
		
		for (AgregadoDto dto : agregados) {
			Pesquisa pesquisa = pesquisaRepository.findByIdIbgePesquisa(dto.getId());

			for (Agregados as : dto.getAgregados()) {
				AgregadoMetadadoDto m = obterAgregadosMetadados(as.getId());
				if (m != null) {
					retorno = true;
					
					Agregado a = new Agregado();
					a.setPesquisa(pesquisa);
					
					Assunto assunto = assuntoRepository.findByDescricao(m.getAssunto());
					a.setAssunto(assunto);
					
					a.setIdIbgeAgregado(Integer.parseInt(m.getId()));
					a.setNome(m.getNome());
					a.setUrlAgregado(m.getURL());
					a.setVersaoCarga(versaoCarga);
					agregadoRepository.save(a);
					
					Periodicidade periodicidade = periodicidadeRepository.findByDescricaoContainingIgnoreCase(m.getPeriodicidade().getFrequencia());
					PeriodicidadeAgregado pa = new PeriodicidadeAgregado();
					pa.setAgregado(a);
					pa.setPeriodicidade(periodicidade);
					pa.setIdIbgePeriodicidade(periodicidade.getId());
					pa.setFrequencia(m.getPeriodicidade().getFrequencia());
					pa.setInicio(m.getPeriodicidade().getInicio());
					pa.setFim(m.getPeriodicidade().getFim());
					periodicidadeAgregadoRepository.save(pa);
					
					if (!m.getNivelTerritorial().getAdministrativo().isEmpty())
					{
						for (String n : m.getNivelTerritorial().getAdministrativo()) {
							Nivel nivel = nivelRepository.findByIdIbgeNivelContainingIgnoreCase(n);
							
							NivelAgregado na = new NivelAgregado();
							na.setAgregado(a);
							na.setNivelAdmin(nivel);
							nivelAgregadoRepository.save(na);
						}
					}
					
					if (!m.getNivelTerritorial().getEspecial().isEmpty())
					{
						for (String n : m.getNivelTerritorial().getEspecial()) {
							Nivel nivel = nivelRepository.findByIdIbgeNivelContainingIgnoreCase(n);
							
							NivelAgregado na = new NivelAgregado();
							na.setAgregado(a);
							na.setNivelEspecial(nivel);
							nivelAgregadoRepository.save(na);
						}
					}
					
					if (!m.getNivelTerritorial().getIbge().isEmpty())
					{
						for (String n : m.getNivelTerritorial().getIbge()) {
							Nivel nivel = nivelRepository.findByIdIbgeNivelContainingIgnoreCase(n);
							
							NivelAgregado na = new NivelAgregado();
							na.setAgregado(a);
							na.setNivelEspecial(nivel);
							nivelAgregadoRepository.save(na);
						}
					}
					
					for (br.gov.prefeitura.mimg.service.AgregadoMetadadoDto.Variavel vDto : m.getVariaveis()) {
						Variavel v = new Variavel();
						v.setAgregado(a);
						v.setIdIbgeVariavel(Integer.parseInt(vDto.getId()));
						v.setNome(vDto.getNome());
						v.setUnidade(vDto.getUnidade());
						variavelRepository.save(v);
					}
					
					for (br.gov.prefeitura.mimg.service.AgregadoMetadadoDto.Classificacao cDto : m.getClassificacoes()) {
						SumarizacaoClassificacao sm = new SumarizacaoClassificacao();
						sm.setStatus(cDto.getSumarizacao().getStatus());
						sumarizacaoClassificacaoRepository.save(sm);
						
						ClassificacaoAgregado ca = new ClassificacaoAgregado();
						ca.setAgregado(a);
						Classificacao classificacao = classificacaoRepository.findByIdIbgeClassificacao(Integer.parseInt(cDto.getId()));
						ca.setClassificacao(classificacao);
						ca.setNome(cDto.getNome());
						ca.setSumarizacaoClassificacao(sm);
						classificacaoAgregadoRepository.save(ca);
						
						for (br.gov.prefeitura.mimg.service.AgregadoMetadadoDto.Categoria caDto : cDto.getCategorias()) {
							Categoria c = new Categoria();
							c.setClassificacaoAgregado(ca);
							c.setIdIbgeCategoria(caDto.getId());
							c.setNivel(caDto.getNivel());
							c.setNome(caDto.getNome());
							c.setUnidade(caDto.getUnidade());
							categoriaRepository.save(c);
						}
					}
				}
			}
		}
		return retorno;
	}
	
	public String retornaDescricaoVersaoCarga()
	{
		VersaoCarga versaoCarga = versaoCargaRepository.findTopByOrderByIdDesc();
		Integer id = 0;
		if (versaoCarga != null)
			id = versaoCarga.getId();
		id++;
		return id + " - " + DataUtil.formatar("dd/MM/yyyy") + " - " + DataUtil.formatar("HH:mm:ss");
	}
}