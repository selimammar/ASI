package com.sp.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class LoginRequest {
	@Email(message = "Email invalide")
	@NotNull(message = "Email vide" )
	String email;
	
	@NotNull(message = "Mot de passe vide")
	String password;
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}

}
