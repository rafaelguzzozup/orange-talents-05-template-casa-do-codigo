package br.com.zupacademy.guzzo.casadocodigo.controller.form;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.zupacademy.guzzo.casadocodigo.model.Categoria;
import br.com.zupacademy.guzzo.casadocodigo.validator.VerificaNomeDuplicadoCategoria;

public class NovaCategoriaForm {

	@NotBlank
	@VerificaNomeDuplicadoCategoria
	public String nome;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public NovaCategoriaForm(@NotBlank String nome) {
		this.nome = nome;
	}

	public Categoria converterParaCategoria() {
		return new Categoria(nome);
	}

}
