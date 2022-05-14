package com.generation.lojadegames.model;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_usuario")
public class Usuario {
	
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotBlank
		private String nome;
		
		@NotNull
		@Email (message = "Usuário deve ser um e-mail válido! \n Exemplo: charliebrown@jigjey.com")
		private String usuario;
		
		@NotBlank
		@Size(min = 4, max = 100, message = "No mínimo 4 caracteres, por favor.")
		private String senha;  
		
		private String foto;
		
		@OneToMany (mappedBy = "usuario", cascade = CascadeType.ALL)
		@JsonIgnoreProperties ("usuario")
		private List <Produto> produto;
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public String getFoto() {
			return foto;
		}

		public void setFoto(String foto) {
			this.foto = foto;
		}

		public List<Produto> getPostagem() {
			return produto;
		}

		public void setPostagem(List<Produto> produto) {
			this.produto = produto;
		}
}