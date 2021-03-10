package br.gov.prefeitura.mimg.bean;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@SessionScoped
public class BeanMenu {
	
	@Value("${app.producao}")
	private String producao;

	@Value("${app.url.mimg}")
	private String urlMimg;

	@Value("${app.url.msc}")
	private String urlMsc;

	@Value("${app.url.sgm}")
	private String urlSgm;
	
	@Value("${app.port.mimg}")
	private String portMimg;
	
	@Value("${app.port.msc}")
	private String portMsc;
	
	@Value("${app.port.sgm}")
	private String portSgm;

	public void sair() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("token");

		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		try {
			ec.redirect(getUrlSgm());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String retornarPath(String porta) {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        try {
        	URI uri = new URI(request.getRequestURL().toString());
			String url = uri.getScheme() + "://" + uri.getHost() + ":";
			if ("true".equals(producao))
				url = url + uri.getPort();
			else
				url = url + porta;
			return url;
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
        return null;
	}

	public String getUrlMsc() {
		FacesContext context = FacesContext.getCurrentInstance();
		String loken = (String) context.getExternalContext().getSessionMap().get("token");
		return retornarPath(portMsc) + urlMsc + "?token=" + loken;
	}
	
	public String getUrlMimg() {
		return retornarPath(portMimg) + urlMimg;
	}
	
	public String getUrlSgm() {
		return retornarPath(portSgm) + urlSgm;
	}
}