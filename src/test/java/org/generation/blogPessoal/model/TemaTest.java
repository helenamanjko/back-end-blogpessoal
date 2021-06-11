package org.generation.blogPessoal.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TemaTest {

	
	public Tema tema;
	
	@Autowired
	private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	
	@BeforeEach
	public void start() {
		tema = new Tema(1L, "Dia a Dia ");
	}
	
	@Test
    public void testValidationAtributos(){
       
		tema.setDescricao("Dia a Dia");
		tema.setId(1);
		tema.setPostagem(null);
        
		//Armazena a lista de Mensagens de Erros de Validação da Model
		Set<ConstraintViolation<Tema>> violations = validator.validate(tema);
        
		//Exibe as Mensagens de Erro se existirem
		System.out.println(violations.toString());
        
        //O Teste só passará se a Lista de Erros estiver vazia!
        assertTrue(violations.isEmpty());
                
    }
}
