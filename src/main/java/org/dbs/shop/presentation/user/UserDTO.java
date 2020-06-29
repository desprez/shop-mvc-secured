package org.dbs.shop.presentation.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDTO {

	@NotNull
	private String name;

	@Email(message = "{errors.invalid_email}")
	private String email;

	@Size(min = 4)
	private String password;

	private String roles;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(final String roles) {
		this.roles = roles;
	}


}
