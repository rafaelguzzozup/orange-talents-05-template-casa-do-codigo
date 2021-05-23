package br.com.zupacademy.guzzo.casadocodigo.controller.form;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.guzzo.casadocodigo.model.Cliente;
import br.com.zupacademy.guzzo.casadocodigo.model.Estado;
import br.com.zupacademy.guzzo.casadocodigo.model.Pais;
import br.com.zupacademy.guzzo.casadocodigo.validator.CPFouCNPJ;
import br.com.zupacademy.guzzo.casadocodigo.validator.ExisteId;
import br.com.zupacademy.guzzo.casadocodigo.validator.UnicoRegistro;

public class ClienteForm {

	@NotBlank
	@Email
	@UnicoRegistro(entidade = Cliente.class, atributo = "email")
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@NotBlank
	@CPFouCNPJ
	@UnicoRegistro(entidade = Cliente.class, atributo = "documento")
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
	@ExisteId(entidade = Pais.class, atributo = "id")
	private Long IdPais;

	@ExisteId(entidade = Estado.class, atributo = "id")
	private Long idEstado;

	public ClienteForm(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotBlank String telefone, @NotBlank String cep, @NotNull Long idPais,
			Long idEstado) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.telefone = telefone;
		this.cep = cep;
		this.IdPais = idPais;
		this.idEstado = idEstado;
	}

	public Cliente converterParaCliente(EntityManager em) {
		@NotNull
		Pais pais = em.find(Pais.class, IdPais);
		Cliente cliente = new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, telefone, cep,
				pais);

		if (this.idEstado != null) {
			Estado estado = em.find(Estado.class, idEstado);
			cliente.setEstado(estado);
		}

		return cliente;
	}

	public Long getIdPais() {
		return IdPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}
}
