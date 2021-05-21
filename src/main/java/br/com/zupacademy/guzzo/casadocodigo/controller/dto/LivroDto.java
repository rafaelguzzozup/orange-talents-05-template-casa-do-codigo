package br.com.zupacademy.guzzo.casadocodigo.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zupacademy.guzzo.casadocodigo.model.Livro;

public class LivroDto {

	private Long id;
	private String nome;

	public LivroDto(Livro livro) {
		this.id = livro.getId();
		this.nome = livro.getTitulo();
	}

	public static List<LivroDto> converterListaLivrosParaDto(List<Livro> livros) {
		return livros.stream().map(LivroDto::new).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
