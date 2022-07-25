package com.project.ElectricityBillingSystem.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="login")
public class LoginEntity {
	
	@Id	
	@Email(message = "Email should be valid")
	private String email;

	@NotNull(message = "password is mandatory")
	@Size(min=3, max=10, message="Min 3 and max 10 charecters are allowed")
	private String password;
	
	@NotNull(message = "role is mandatory")
	@Size(min=3, max=10, message="Min 3 and max 10 charecters are allowed")
	private String role;
	
	private boolean isLoggedIn;
	
	@OneToOne(mappedBy = "loginEntity")
    private CustomerEntity customerEntity;

	public LoginEntity() {
		super();
	}

	public LoginEntity( String email, String password, String role, boolean isLoggedIn) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
		this.isLoggedIn = isLoggedIn;
	}



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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
    public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	@Override
	public String toString() {
		return "LoginEntity [email=" + email + ", password=" + password + ", role=" + role + ", isLoggedIn="
				+ isLoggedIn + "]";
	}

}
