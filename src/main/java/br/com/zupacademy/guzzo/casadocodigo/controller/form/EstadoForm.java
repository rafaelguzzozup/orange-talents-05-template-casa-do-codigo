package br.com.zupacademy.guzzo.casadocodigo.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.guzzo.casadocodigo.model.Estado;
import br.com.zupacademy.guzzo.casadocodigo.model.Pais;
import br.com.zupacademy.guzzo.casadocodigo.validator.ExisteId;

public class EstadoForm {

	@NotBlank
	private String nome;

	@NotNull
	@ExisteId(entidade = Pais.class, atributo = "id")
	private Long idPais;

	public EstadoForm(@NotBlank String nome, @NotNull Long idPais) {
		this.nome = nome;
		this.idPais = idPais;
	}

	public Estado converterParaEstado(Pais pais) {
		return new Estado(nome, pais);
	}

	public Long getIdPais() {
		return idPais;
	}

	public String getNome() {
		return nome;
	}
}
