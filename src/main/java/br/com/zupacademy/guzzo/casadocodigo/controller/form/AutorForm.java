package br.com.zupacademy.guzzo.casadocodigo.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.guzzo.casadocodigo.model.Autor;
import br.com.zupacademy.guzzo.casadocodigo.validator.VerificaEmailDuplicadoAutor;

public class AutorForm {

	@NotNull
	@NotBlank
	private String nome;

	@NotNull
	@NotBlank
	@Email
	@VerificaEmailDuplicadoAutor
	private String email;

	@NotNull
	@NotBlank
	@Size(max = 400)
	private String descricao;

	public AutorForm(@NotNull @NotBlank String nome, @NotNull @NotBlank @Email String email,
			@NotNull @NotBlank @Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor converterParaAutor() {
		return new Autor(this.nome, this.email, this.descricao);
	}

}
