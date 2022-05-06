package com.generation.farmacia.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long cod;

	@NotNull
	@Size (min = 1, max = 100, message = "O nome do produto só pode ter de 1 a 100 caracteres")
	private String nome;
	
	@NotNull
	@Size (min = 1, max = 500, message = "A descrição do produto só pode ter de 1 a 500 caracteres")
	private String descricao;
	
	@NotNull
	@Positive
	private double valor;
	
	@NotNull
	@Size (min = 10, max = 11, message = "A data de validade só tem 10 caracteres")
	private String validade;
	
	@NotNull
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;

	public Long getCod() {
		return cod;
	}

	public void setCod(Long cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String getValidade() {
		return validade;
	}

	public void setData(String validade) {
		this.validade = validade;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
