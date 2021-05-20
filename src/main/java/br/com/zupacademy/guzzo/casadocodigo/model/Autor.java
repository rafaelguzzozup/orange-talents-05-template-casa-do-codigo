package br.com.zupacademy.guzzo.casadocodigo.model;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotBlank
	private String nome;

	@NotNull
	@NotBlank
	@Email
	@Column(unique = true)
	private String email;

	@NotNull
	@NotBlank
	@Size(max = 400)
	private String descricao;

	private OffsetDateTime dataRegistro = OffsetDateTime.now();

	@Deprecated
	public Autor() {

	}

	public Autor(String nome, String email, String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nome=" + nome + ", email=" + email + ", descricao=" + descricao
				+ ", dataRegistro=" + dataRegistro + "]";
	}

}
