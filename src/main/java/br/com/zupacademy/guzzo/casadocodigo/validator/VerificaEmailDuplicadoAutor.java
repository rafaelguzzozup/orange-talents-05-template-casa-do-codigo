package br.com.zupacademy.guzzo.casadocodigo.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidadorDeEmailDuplicadoAutor.class)
public @interface VerificaEmailDuplicadoAutor {

	String message() default "Email já cadastrado no banco de dados!";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
