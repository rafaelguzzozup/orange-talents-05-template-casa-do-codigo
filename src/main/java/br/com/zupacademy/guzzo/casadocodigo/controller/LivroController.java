package br.com.zupacademy.guzzo.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.guzzo.casadocodigo.controller.form.NovoLivroForm;
import br.com.zupacademy.guzzo.casadocodigo.model.Autor;
import br.com.zupacademy.guzzo.casadocodigo.model.Categoria;
import br.com.zupacademy.guzzo.casadocodigo.model.Livro;
import br.com.zupacademy.guzzo.casadocodigo.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;

	@PersistenceContext
	private EntityManager em;

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@Valid @RequestBody NovoLivroForm livroForm) {

		Categoria categoria = em.find(Categoria.class, livroForm.getIdCategoria());
		Autor autor = em.find(Autor.class, livroForm.getIdAutor());

		if (categoria == null || autor == null) {
			return ResponseEntity.badRequest().body("O id de Categoria ou Autor não existe no banco!");
		}

		Livro livro = livroForm.converterParaLivro(categoria, autor);
		em.persist(livro);
		return ResponseEntity.ok().build();

	}

}
