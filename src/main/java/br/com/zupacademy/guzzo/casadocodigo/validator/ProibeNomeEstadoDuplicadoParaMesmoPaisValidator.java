package br.com.zupacademy.guzzo.casadocodigo.validator;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.guzzo.casadocodigo.controller.form.EstadoForm;
import br.com.zupacademy.guzzo.casadocodigo.model.Estado;

@Component
public class ProibeNomeEstadoDuplicadoParaMesmoPaisValidator implements Validator {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean supports(Class<?> clazz) {
		return EstadoForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		EstadoForm form = (EstadoForm) target;

		Query query = entityManager
				.createQuery("select 1 from " + Estado.class.getName() + " where nome = :nome and pais_id= :pais");

		query.setParameter("nome", form.getNome());
		query.setParameter("pais", form.getIdPais());

		List<?> resultado = query.getResultList();
		if (resultado.size() != 1) {
			errors.rejectValue("nome", HttpStatus.BAD_REQUEST.name(),
					"Já existe o nome " + form.getNome() + " para o pais de id:" + form.getIdPais());
		}
	}

}
