package br.com.mosdev.aluraflix.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="Recurso Não encontrado")
public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
}
