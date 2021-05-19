package br.com.zupacademy.guzzo.casadocodigo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zupacademy.guzzo.casadocodigo.repository.AutorRepository;

public class ValidadorDeEmailDuplicadoAutor implements ConstraintValidator<VerificaEmailDuplicadoAutor, String> {

	@Autowired
	private AutorRepository autorRepository;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return !this.autorRepository.findByEmail(value).isPresent();
	}

}
