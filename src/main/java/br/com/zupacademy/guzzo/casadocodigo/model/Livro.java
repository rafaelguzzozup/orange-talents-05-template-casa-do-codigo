package br.com.zupacademy.guzzo.casadocodigo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(unique = true)
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
	@Column(unique = true)
	private String isbn;

	@Future
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataPublicacao;

	@NotNull
	@OneToOne
	private Categoria categoria;

	@NotNull
	@OneToOne
	private Autor autor;

	@Deprecated
	public Livro() {
	}

	public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
			@NotNull @DecimalMin(value = "20.00", inclusive = true) BigDecimal preco,
			@NotNull @Min(100) Integer numeroPaginas, @NotBlank String isbn, @Future LocalDate dataPublicacao,
			@NotNull Categoria categoria, @NotNull Autor autor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", resumo=" + resumo + ", sumario=" + sumario + ", preco="
				+ preco + ", numeroPaginas=" + numeroPaginas + ", isbn=" + isbn + ", dataPublicacao=" + dataPublicacao
				+ ", categoria=" + categoria + ", autor=" + autor + "]";
	}

}
