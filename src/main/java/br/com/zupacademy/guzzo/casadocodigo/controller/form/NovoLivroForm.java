package br.com.zupacademy.guzzo.casadocodigo.controller.form;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.Lob;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zupacademy.guzzo.casadocodigo.model.Autor;
import br.com.zupacademy.guzzo.casadocodigo.model.Categoria;
import br.com.zupacademy.guzzo.casadocodigo.model.Livro;
import br.com.zupacademy.guzzo.casadocodigo.validator.ExisteId;
import br.com.zupacademy.guzzo.casadocodigo.validator.UnicoRegistro;

public class NovoLivroForm {

	@NotBlank
	@UnicoRegistro(entidade = Livro.class, atributo = "titulo")
	private String titulo;

	@NotBlank
	@Size(max = 500)
	private String resumo;

	@Lob
	private String sumario;

	@NotNull
	@DecimalMin(value = "20.00", inclusive = true)
	private BigDecimal preco;

	@NotNull
	@Min(100)
	private Integer numeroPaginas;

	@NotBlank
	@UnicoRegistro(entidade = Livro.class, atributo = "isbn")
	private String isbn;

	@Future
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataPublicacao;

	@NotNull
	@ExisteId(entidade = Categoria.class, atributo = "id")
	private Long idCategoria;

	@NotNull
	@ExisteId(entidade = Autor.class, atributo = "id")
	private Long idAutor;

	public NovoLivroForm(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
			@NotNull @DecimalMin(value = "20.00", inclusive = true) BigDecimal preco,
			@NotNull @Min(100) Integer numeroPaginas, @NotBlank String isbn, @NotNull Long idCategoria,
			@NotNull Long idAutor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}

	public Livro converterParaLivro(EntityManager em) {
		@NotNull
		Categoria categoria = em.find(Categoria.class, this.idCategoria);

		@NotNull
		Autor autor = em.find(Autor.class, this.idAutor);
		return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, categoria, autor);
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public Long getIdAutor() {
		return idAutor;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

}
