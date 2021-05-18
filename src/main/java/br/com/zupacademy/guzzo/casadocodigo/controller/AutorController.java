package br.com.zupacademy.guzzo.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.guzzo.casadocodigo.controller.form.AutorForm;
import br.com.zupacademy.guzzo.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	private AutorRepository autorRepository;

	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody @Valid AutorForm autorForm) {
		this.autorRepository.save(autorForm.converterParaAutor());

		return ResponseEntity.ok().build();
	}

}
