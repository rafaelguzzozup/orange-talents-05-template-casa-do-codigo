package br.com.zupacademy.guzzo.casadocodigo.validator;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UnicoRegistroValidator implements ConstraintValidator<UnicoRegistro, String> {

	@PersistenceContext
	private EntityManager entityManager;

	private Class<?> entidade;
	private String atributo;

	@Override
	public void initialize(UnicoRegistro unicoRegistroAnotacao) {
		this.entidade = unicoRegistroAnotacao.entidade();
		this.atributo = unicoRegistroAnotacao.atributo();
	}

	@Override
	public boolean isValid(String valor, ConstraintValidatorContext context) {
		Query query = entityManager
				.createQuery("select 1 from " + this.entidade.getName() + " where " + this.atributo + " = :id");

		query.setParameter("id", valor);

		List<?> resultado = query.getResultList();
		return resultado.isEmpty();

	}

}
