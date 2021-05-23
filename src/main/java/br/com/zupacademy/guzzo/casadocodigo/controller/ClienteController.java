package br.com.zupacademy.guzzo.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.guzzo.casadocodigo.controller.form.ClienteForm;
import br.com.zupacademy.guzzo.casadocodigo.validator.ValidaSeEstadoPertenceAPais;
import br.com.zupacademy.guzzo.casadocodigo.validator.ValidaSePaisTemEstados;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private ValidaSePaisTemEstados validaSePaisTemEstados;

	@Autowired
	private ValidaSeEstadoPertenceAPais validaSeEstadoPertenceAPais;

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(validaSePaisTemEstados, validaSeEstadoPertenceAPais);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@Valid @RequestBody ClienteForm form) {

		em.persist(form.converterParaCliente(em));
		return ResponseEntity.ok().build();
	}

}
