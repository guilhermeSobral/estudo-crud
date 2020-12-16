package com.crudcompleto.oauth.entities;

public class Role {	
	
	private Long id;
	private String roleName;
	
	public Role() {}

	public Role(String roleName) {
		this.roleName = roleName;
	}

	public Long getId() {
		return id;
	}

	public String getRoleName() {
		return roleName;
	}	
}
