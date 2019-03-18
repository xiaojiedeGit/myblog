package com.myblog.model;

public class User {
	private String name;
	
	private String password;
	
	private Roles roles;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", roles=" + roles + "]";
	}
}
