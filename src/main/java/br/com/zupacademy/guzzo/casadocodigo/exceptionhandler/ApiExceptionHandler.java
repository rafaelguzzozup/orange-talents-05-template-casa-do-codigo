package br.com.zupacademy.guzzo.casadocodigo.exceptionhandler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorSaidaDto handleValidationError(MethodArgumentNotValidException exception) {

		ErrorSaidaDto errorSaidaDto = new ErrorSaidaDto("Um ou mais campos estão invalidos!");

		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

		for (FieldError error : fieldErrors) {
			String nome = ((FieldError) error).getField();
			String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());

			errorSaidaDto.adicionaCampoComErro(nome, mensagem);
		}

		return errorSaidaDto;

	}

}
