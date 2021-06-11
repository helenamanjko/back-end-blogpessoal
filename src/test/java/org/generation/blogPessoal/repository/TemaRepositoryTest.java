package org.generation.blogPessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.generation.blogPessoal.model.Tema;
import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TemaRepositoryTest {
	
	@Autowired
	private TemaRepository temaRepository;
	
	/*@BeforeAll
	public void start() {
		Tema tema = new Tema(1L, "Dia a dia 2");
		if (temaRepository.findFirstByDescricao(tema.getDescricao()) == null)
			temaRepository.save(tema);
	}*/
	
	@Test
	public void findFirstByDescricao() throws Exception {

		Tema tema = temaRepository.findFirstByDescricao("Dia a dia");

		assertTrue(tema.getDescricao().equals("Dia a dia"));
	}
	@Test
	public void findAllByNomeIgnoreCaseRetornaResultado() {

		List<Tema> temas = temaRepository.findAllByDescricaoContainingIgnoreCase("dia");

		assertEquals(1, temas.size());
	}
	
	@AfterAll
	public void end() {
		temaRepository.deleteAll();
	}
	

}
