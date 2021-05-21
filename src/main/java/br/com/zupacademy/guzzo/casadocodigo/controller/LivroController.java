package br.com.zupacademy.guzzo.casadocodigo.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.guzzo.casadocodigo.controller.dto.DetalheLivroDto;
import br.com.zupacademy.guzzo.casadocodigo.controller.dto.LivroDto;
import br.com.zupacademy.guzzo.casadocodigo.controller.form.NovoLivroForm;
import br.com.zupacademy.guzzo.casadocodigo.model.Autor;
import br.com.zupacademy.guzzo.casadocodigo.model.Categoria;
import br.com.zupacademy.guzzo.casadocodigo.model.Livro;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@PersistenceContext
	private EntityManager em;

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@Valid @RequestBody NovoLivroForm livroForm) {
		Livro livro = livroForm.converterParaLivro(em);
		em.persist(livro);
		return ResponseEntity.ok().build();

	}

	@GetMapping
	public List<LivroDto> listaDeLivros() {
		List<Livro> livros = em.createQuery("from Livro").getResultList();

		return LivroDto.converterListaLivrosParaDto(livros);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetalheLivroDto> detalheLivro(@PathVariable Long id) {
		Livro livro = em.find(Livro.class, id);
		if (livro == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(new DetalheLivroDto(livro));
	}
}
