package br.com.zupacademy.guzzo.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.zupacademy.guzzo.casadocodigo.controller.form.EstadoForm;
import br.com.zupacademy.guzzo.casadocodigo.model.Pais;
import br.com.zupacademy.guzzo.casadocodigo.validator.ProibeNomeEstadoDuplicadoParaMesmoPaisValidator;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private ProibeNomeEstadoDuplicadoParaMesmoPaisValidator proibeNomeEstadoDuplicadoParaMesmoPais;

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@Valid @RequestBody EstadoForm estadoForm) {
		Pais pais = em.find(Pais.class, estadoForm.getIdPais());

		if (pais == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Não foram encontrados registros de Pais para o id " + estadoForm.getIdPais());
		}

		em.persist(estadoForm.converterParaEstado(pais));

		return ResponseEntity.ok().build();
	}

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeNomeEstadoDuplicadoParaMesmoPais);
	}
}
