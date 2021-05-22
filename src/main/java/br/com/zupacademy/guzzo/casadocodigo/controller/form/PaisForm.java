package br.com.zupacademy.guzzo.casadocodigo.controller.form;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.zupacademy.guzzo.casadocodigo.model.Pais;
import br.com.zupacademy.guzzo.casadocodigo.validator.UnicoRegistro;

public class PaisForm {

	@NotBlank
	@UnicoRegistro(entidade = Pais.class, atributo = "nome")
	private String nome;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public PaisForm(@NotBlank String nome) {
		this.nome = nome;
	}

	public Pais converterParaPais() {
		return new Pais(this.nome);
	}

}
