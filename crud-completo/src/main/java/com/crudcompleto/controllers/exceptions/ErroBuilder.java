package com.crudcompleto.controllers.exceptions;

import java.time.LocalDateTime;

public class ErroBuilder {
	
	private Integer status;
	private String type;
	private String title;
	private String detail;
	private String userMsg;
	private LocalDateTime timestamp;
	
	public ErroBuilder setStatus(Integer status) {
		this.status = status;
		return this;
	}
	public ErroBuilder setType(String type) {
		this.type = type;
		return this;
	}
	public ErroBuilder setTitle(String title) {
		this.title = title;
		return this;
	}
	public ErroBuilder setDetail(String detail) {
		this.detail = detail;
		return this;
	}	
	
	public ErroBuilder setUserMsg(String userMsg) {
		this.userMsg = userMsg;
		return this;
	}
	
	public ErroBuilder setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
		return this;
	}
	public Erro build() {
		return new Erro(status, type, title, detail, userMsg, timestamp);
	}

}
