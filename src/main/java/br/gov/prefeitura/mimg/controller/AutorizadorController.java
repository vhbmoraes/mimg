package br.gov.prefeitura.mimg.controller;

import javax.faces.context.FacesContext;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutorizadorController {
	
	@RequestMapping("/autorizacao")
	public String autorizacao(String login)
	{
		if (login == null)
			return "Falhou";
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().put("usuarioLogado", login);
		
		return "Sucesso";
	}
	
}
