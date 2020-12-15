package com.crudcompleto.controllers.exceptions;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Erro {
	
	private Integer status;
	private String type;
	private String title;
	private String detail;
	
	private String userMsg;
	private LocalDateTime timestamp;

	public Erro(Integer status, String type, String title, String detail, String userMsg, LocalDateTime timestamp) {
		this.status = status;
		this.type = type;
		this.title = title;
		this.detail = detail;
		this.userMsg = userMsg;
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public String getType() {
		return type;
	}

	public String getTitle() {
		return title;
	}

	public String getDetail() {
		return detail;
	}
	
	public String getUserMsg() {
		return userMsg;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public static ErroBuilder builder() {
		return new ErroBuilder();
	}
}
