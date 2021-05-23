package br.com.zupacademy.guzzo.casadocodigo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Email
	@Column(unique = true)
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@NotBlank
	@Column(unique = true)
	private String documento;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;

	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;

	@NotNull
	@ManyToOne
	private Pais pais;

	@ManyToOne
	private Estado estado;

	@Deprecated
	public Cliente() {

	}

	public Cliente(String email, @NotBlank String nome, @NotBlank String sobrenome, @NotBlank String documento,
			@NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, @NotBlank String telefone,
			@NotBlank String cep, @NotNull Pais pais) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.telefone = telefone;
		this.cep = cep;
		this.pais = pais;
	}

	public void setEstado(Estado estado) {
		if (!estado.pertenceAPais(pais)) {
			throw new IllegalArgumentException("O estado selecionado não pertence ao Pais!");
		}
		this.estado = estado;
	}

}
