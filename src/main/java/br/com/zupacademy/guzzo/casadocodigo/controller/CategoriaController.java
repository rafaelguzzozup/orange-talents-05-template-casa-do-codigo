package br.com.zupacademy.guzzo.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.guzzo.casadocodigo.controller.form.NovaCategoriaForm;
import br.com.zupacademy.guzzo.casadocodigo.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@Valid @RequestBody NovaCategoriaForm novaCategoriaForm) {
		categoriaRepository.save(novaCategoriaForm.converterParaCategoria());

		return ResponseEntity.ok().build();
	}
}
