package br.gov.prefeitura.mimg.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.gov.prefeitura.mimg.bean.ClassificacaoDto;
import br.gov.prefeitura.mimg.entity.Agregado;
import br.gov.prefeitura.mimg.entity.Localidade;
import br.gov.prefeitura.mimg.entity.ResultadoAgregado;
import br.gov.prefeitura.mimg.entity.Variavel;
import br.gov.prefeitura.mimg.repository.AgregadoRepository;
import br.gov.prefeitura.mimg.repository.LocalidadeRepository;
import br.gov.prefeitura.mimg.repository.ResultadoAgregadoRepository;
import br.gov.prefeitura.mimg.repository.VariavelRepository;
import br.gov.prefeitura.mimg.service.LocalidadeDto.Resultado;
import br.gov.prefeitura.mimg.service.LocalidadeDto.Series;

@Service
public class CadastrarResultadoAgregadoService {
	
	@Autowired
	private AgregadoRepository agregadoRepository;
	
	@Autowired
	private VariavelRepository variavelRepository;
	
	@Autowired
	private LocalidadeRepository localidadeRepository;
	
	@Autowired
	private ResultadoAgregadoRepository resultadoAgregadoRepository;
	
	@Value("${app.url.ibge}")
	private String urlIbge;

	public List<LocalidadeDto> pesquisar(String filtro) {
		try {
			String url = urlIbge + filtro;

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

			LocalidadeDto[] dto = gson.fromJson(new String(output.getBytes()), LocalidadeDto[].class);
			List<LocalidadeDto> localidades = new ArrayList<LocalidadeDto>();
			for (LocalidadeDto a : dto) {
				localidades.add(a);
			}
			return localidades;

		} catch (IOException ex) {
			ex.getMessage();
		}
		return null;
	}

	private String montarFiltro(Integer idIbgeAgregado, String periodo, Integer idIbgeVariavel, String idIbgeNivel, Integer idLocalidade, List<ClassificacaoDto> classificacaoes) {
		return "/" + idIbgeAgregado + "/periodos/" + periodo + "/variaveis/" + idIbgeVariavel + "?localidades=N3[31]" + montarFiltroClassificacao(classificacaoes);
	}
	
	private String montarFiltroClassificacao(List<ClassificacaoDto> classificacaoes) {
		String param = "&classificacao=";
		for (ClassificacaoDto dto : classificacaoes) {
			param = param + dto.getClassificacaoAgregado().getClassificacao().getIdIbgeClassificacao() + "[" + dto.getCategoria().getIdIbgeCategoria() + "]|";
		}
		return param.substring(0, param.length() - 1);
	}

	@Transactional
	public Boolean cadastrar(Integer agregadoId, String periodo, Integer variavelId, Integer idLocalidade, List<ClassificacaoDto> classificacaoes) {
		boolean retorno = false;
		Optional<Agregado> a = agregadoRepository.findById(agregadoId);
		Optional<Variavel> v = variavelRepository.findById(variavelId);
		Optional<Localidade> l = localidadeRepository.findById(idLocalidade);
		
		Integer idIbgeAgregado = a.get().getIdIbgeAgregado();
		Integer idIbgeVariavel = v.get().getIdIbgeVariavel();
		String idIbgeNivel = l.get().getNivel().getIdIbgeNivel();
		
		String filtro = montarFiltro(idIbgeAgregado, periodo, idIbgeVariavel, idIbgeNivel, idLocalidade, classificacaoes);
		List<LocalidadeDto> dtos = pesquisar(filtro);
		if  (dtos == null)
			return false;
		
		for (LocalidadeDto dto : dtos) {
			for (Resultado r : dto.getResultados()) {
				for (Series s : r.getSeries()) {
					retorno = true;
					
					ResultadoAgregado ra = new ResultadoAgregado(); 
					ra.setAgregado(a.get());
					ra.setClassificacaoAgregado(classificacaoes.get(0).getClassificacaoAgregado());
					ra.setReferenciaSerie(periodo);
					ra.setVariavel(v.get());
					ra.setLocalidade(l.get());
					ra.setValorSerie(s.getSerie().getValor());
					resultadoAgregadoRepository.save(ra);
				}
			}			
		}
		return retorno;
	}
}