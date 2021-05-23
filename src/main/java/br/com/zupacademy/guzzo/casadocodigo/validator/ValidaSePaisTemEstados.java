package br.com.zupacademy.guzzo.casadocodigo.validator;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.guzzo.casadocodigo.controller.form.ClienteForm;
import br.com.zupacademy.guzzo.casadocodigo.controller.form.EstadoForm;
import br.com.zupacademy.guzzo.casadocodigo.model.Estado;

@Component
public class ValidaSePaisTemEstados implements Validator {

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

		if (form.getIdEstado() == null) {
			Query query = entityManager
					.createQuery("select 1 from " + Estado.class.getName() + " where pais_id= :pais");

			query.setParameter("pais", form.getIdPais());

			List<?> resultado = query.getResultList();
			if (!resultado.isEmpty()) {
				errors.rejectValue("idEstado", HttpStatus.BAD_REQUEST.name(),
						"O pais possui estados, por favor selecione um!");
			}

		}
	}

}
