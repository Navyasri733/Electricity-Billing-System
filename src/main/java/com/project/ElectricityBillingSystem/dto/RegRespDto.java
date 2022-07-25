package com.project.ElectricityBillingSystem.dto;

public class RegRespDto {
	
	private String full_name;
	private String email;
	private boolean isLoggedIn ;
	private String role;
	
	public RegRespDto() {
		super();
		
	}

	public RegRespDto(String full_name, String email, boolean isLoggedIn, String role) {
		super();
		this.full_name = full_name;
		this.email = email;
		this.isLoggedIn = isLoggedIn;
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

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "RegRespDto [full_name=" + full_name + ", email=" + email + ", isLoggedIn=" + isLoggedIn + ", role="
				+ role + "]";
	}

}
