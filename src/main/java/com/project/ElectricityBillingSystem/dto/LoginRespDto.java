package com.project.ElectricityBillingSystem.dto;

public class LoginRespDto {
	
	private String email;
	private String role;
	private boolean isLoggedIn;
	
	public LoginRespDto() {
		super();
		
	}

	public LoginRespDto(String email, String role, boolean isLoggedIn) {
		super();
		this.email = email;
		this.role = role;
		this.isLoggedIn = isLoggedIn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		return "LoginRespDto [email=" + email + ", role=" + role + ", isLoggedIn=" + isLoggedIn + "]";
	}

}
