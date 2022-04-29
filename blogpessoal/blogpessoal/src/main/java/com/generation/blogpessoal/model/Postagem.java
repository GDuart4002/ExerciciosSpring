package com.generation.blogpessoal.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table (name = "tb_postagem")
public class Postagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	public Long id;

	@NotNull
	@Size (min = 1 , max = 100, message = "O título tem no mínimo 1 caracter e no máximo 100.")
	public String titulo;
	
	@NotNull
	public String texto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
}