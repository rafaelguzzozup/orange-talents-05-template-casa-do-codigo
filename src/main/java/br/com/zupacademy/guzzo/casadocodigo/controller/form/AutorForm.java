package br.com.zupacademy.guzzo.casadocodigo.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.guzzo.casadocodigo.model.Autor;

public class AutorForm {

	@NotNull
	@NotBlank
	private String nome;

	@NotNull
	@NotBlank
	@Email
	private String email;

	@NotNull
	@NotBlank
	@Size(max = 400)
	private String descricao;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Autor converterParaAutor() {
		return new Autor(this.nome, this.email, this.descricao);
	}

}
