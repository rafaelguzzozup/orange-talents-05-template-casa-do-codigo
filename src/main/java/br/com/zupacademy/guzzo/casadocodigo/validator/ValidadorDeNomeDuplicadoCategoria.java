package br.com.zupacademy.guzzo.casadocodigo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zupacademy.guzzo.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.guzzo.casadocodigo.repository.CategoriaRepository;

public class ValidadorDeNomeDuplicadoCategoria implements ConstraintValidator<VerificaNomeDuplicadoCategoria, String> {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return !this.categoriaRepository.findByNomeIgnoreCase(value).isPresent();
	}

}
