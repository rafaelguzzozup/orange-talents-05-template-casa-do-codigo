package br.com.zupacademy.guzzo.casadocodigo.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zupacademy.guzzo.casadocodigo.model.Livro;

public class DetalheLivroDto {

	private String titulo;

	private String resumo;

	private String sumario;

	private BigDecimal preco;

	private Integer numeroPaginas;

	private String isbn;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataPublicacao;

	private String categoria;

	private String autor;

	public DetalheLivroDto(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numeroPaginas = livro.getNumeroPaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao();
		this.categoria = livro.getCategoria().getNome();
		this.autor = livro.getAutor().getNome();
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public String getCategoria() {
		return categoria;
	}

	public String getAutor() {
		return autor;
	}

}
