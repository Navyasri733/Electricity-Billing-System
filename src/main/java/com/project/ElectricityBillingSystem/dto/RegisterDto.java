package com.project.ElectricityBillingSystem.dto;

public class RegisterDto {
	
	private String full_name;
	private String email;
	private String password;
	private String role;
	
	public RegisterDto() {
		super();
		
	}

	public RegisterDto(String full_name, String email, String password, String role) {
		super();
		this.full_name = full_name;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
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

	@Override
	public String toString() {
		return "RegisterDto [full_name=" + full_name + ", email=" + email + ", password=" + password + ", role=" + role
				+ "]";
	}
	
	
	

}
