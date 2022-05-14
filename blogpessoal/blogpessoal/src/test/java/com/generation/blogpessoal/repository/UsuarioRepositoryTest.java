package com.generation.blogpessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.generation.blogpessoal.model.Usuario;

@SpringBootTest (webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
	
	@Autowired 
	private UsuarioRepository repository;
	
	@BeforeAll
	void start() {
		repository.save(new Usuario(0L, "Maiar da Silva", "isadora@gmail.com", "51 e pega", "https://i.imgur.com/FETvs2O.jpg"));
		repository.save(new Usuario(0L, "Michael da Silva", "michaeltrimundial@gmail.com", "nunca foi rebaixado", "https://i.imgur.com/FETvs2O.jpg"));
		repository.save(new Usuario(0L, "Brocco da Silva", "brocco@gmail.com", "broccolis", "https://i.imgur.com/FETvs2O.jpg"));
		repository.save(new Usuario(0L, "Mayara dos Santos", "will31smith@gmail.com", "cenourinha", "https://i.imgur.com/FETvs2O.jpg"));
	}
	
	@Test
	@DisplayName("Teste que retorna 1 usuario") 
	public void retornaUmUsuario() { 
		Optional <Usuario> usuario = repository.findByUsuario("isadora@gmail.com"); 
		assertTrue(usuario.get().getUsuario().equals("isadora@gmail.com")); 
	}
	
	@Test 
	@DisplayName("Teste que retorna 3 usuários") 
	public void retornaTresUsuario() { 
		List <Usuario> listaDeUsuarios = repository.findAllByNomeContainingIgnoreCase("Silva");
		assertEquals(3, listaDeUsuarios.size()); 
		assertTrue(listaDeUsuarios.get(0).getNome().equals("Maiar da Silva")); 
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Michael da Silva")); 
		assertTrue(listaDeUsuarios.get(2).getNome().equals("Brocco da Silva")); 
	}
	
	@AfterAll
	public void end() {
		repository.deleteAll();
	}
}