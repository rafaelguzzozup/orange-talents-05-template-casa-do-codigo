package br.com.zupacademy.guzzo.casadocodigo.validator;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.guzzo.casadocodigo.controller.form.ClienteForm;
import br.com.zupacademy.guzzo.casadocodigo.model.Estado;
import br.com.zupacademy.guzzo.casadocodigo.model.Pais;

@Component
public class ValidaSeEstadoPertenceAPais implements Validator {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean supports(Class<?> clazz) {
		return ClienteForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		ClienteForm form = (ClienteForm) target;

		if (form.getIdEstado() != null) {
			Pais pais = entityManager.find(Pais.class, form.getIdPais());
			Estado estado = entityManager.find(Estado.class, form.getIdEstado());

			if (!estado.pertenceAPais(pais)) {
				errors.rejectValue("idEstado", HttpStatus.BAD_REQUEST.name(),
						"O estado informado não pertence ao pais selecionado!");
			}

		}
	}

}
