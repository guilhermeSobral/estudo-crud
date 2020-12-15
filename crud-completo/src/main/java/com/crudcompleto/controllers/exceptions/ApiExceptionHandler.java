package com.crudcompleto.controllers.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ObjetoNaoEncontradoException.class)
	public ResponseEntity<?> handleObjetoNaoEncontrado(ObjetoNaoEncontradoException ex, WebRequest request) {
		var httpStatus = HttpStatus.NOT_FOUND;		
		var erro = erroBuilder(httpStatus.value(), 
				null, 
				"Objeto não encontrado", 
				ex.getMessage(), 
				"Ocorreu um erro inesperado, por favor entrar em contato com o suporte");
		return handleExceptionInternal(ex, erro, new HttpHeaders(), httpStatus, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {	
		if(body == null) {
			body = Erro.builder()
				.setTitle(status.getReasonPhrase())
				.setStatus(status.value())
				.build();
		}
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}
	
	private Erro erroBuilder(Integer status, String type, String title, String detail, String userMsg) {
		return Erro.builder()
			.setStatus(status)
			.setType(type)
			.setTitle(title)
			.setDetail(detail)
			.setUserMsg(userMsg)
			.setTimestamp(LocalDateTime.now())
			.build();
	}
}
