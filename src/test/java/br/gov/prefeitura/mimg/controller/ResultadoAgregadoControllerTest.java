package br.gov.prefeitura.mimg.controller;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ResultadoAgregadoControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	/*@Test
	public void test() throws Exception {
		URI uri = new URI("/resultadoAgregado");
		String json = "{}";
		mockMvc
			.perform(MockMvcRequestBuilders
				.get(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers
					.status()
					.is(400));
	}*/

}
