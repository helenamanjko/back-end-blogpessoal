package org.generation.blogPessoal.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.generation.blogPessoal.model.Tema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TemaControllerTest {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	private Tema tema;
	private Tema temaDois;
	
	@BeforeAll
	public void start() {
		tema = new Tema(1, "Dia a dia");
		temaDois = new Tema(2,"Trabalho");
	}
	
	@Test
	public void deveRealizarPostTema() {

		
		/*
		 * Criando um objeto do tipo HttpEntity para enviar como terceiro
		 * parâmentro do método exchange. (Enviando um objto contato via body)
		 * 
		 * */
		HttpEntity<Tema> request = new HttpEntity<Tema>(tema);

		ResponseEntity<Tema> resposta = testRestTemplate.exchange("/tema", HttpMethod.POST, request, Tema.class);
		assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
	}
	
	@Disabled
	@Test
	public void deveMostrarTodosTemas() {
		ResponseEntity<String> resposta = testRestTemplate.exchange("/tema/", HttpMethod.GET, null, String.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
	
	@Disabled
	@Test
	public void deveRealizarPutTemas() {

		HttpEntity<Tema> request = new HttpEntity<Tema>(temaDois);

		ResponseEntity<Tema> resposta = testRestTemplate.exchange("/tema/alterar", HttpMethod.PUT, request, Tema.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
		
	}
	
	@Disabled
	@Test
	public void deveRealizarDeleteContatos() {

		/*
		 * O Contato com Id 3 será apagado somente ele existir no Banco.
		 * Caso contrário, o teste irá falhar!
		 * 
		 * */
		ResponseEntity<String> resposta = testRestTemplate.exchange("/tema/1", HttpMethod.DELETE, null, String.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
		
	}
	
}
