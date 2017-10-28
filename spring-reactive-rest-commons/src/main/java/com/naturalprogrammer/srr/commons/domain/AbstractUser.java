package com.naturalprogrammer.srr.commons.domain;

import java.io.Serializable;

public abstract class AbstractUser<ID extends Serializable> extends AbstractEntity<ID> {
	
	private static final long serialVersionUID = -8289175350021428063L;
	
	// validation groups
	public interface SignUpValidation {}
	public interface UpdateValidation {}
	public interface ChangeEmailValidation {}
	
	// JsonView for Sign up
	public interface SignupInput {}

	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}
