package com.project.ElectricityBillingSystem.dto;

public class CustDto {
	
	private int cust_id;
	private String full_name;
	private String mobile;
	private String email;
	private int bill_id;
	private int service_id;
	private int payment_id;
	private int address_id;
	
	public CustDto() {
		super();
		
	}

	public CustDto(int cust_id, String full_name, String mobile, String email, int bill_id, int service_id,
			int payment_id, int address_id) {
		super();
		this.cust_id = cust_id;
		this.full_name = full_name;
		this.mobile = mobile;
		this.email = email;
		this.bill_id = bill_id;
		this.service_id = service_id;
		this.payment_id = payment_id;
		this.address_id = address_id;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBill_id() {
		return bill_id;
	}

	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}

	public int getService_id() {
		return service_id;
	}

	public void setService_id(int service_id) {
		this.service_id = service_id;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	@Override
	public String toString() {
		return "CustDto [cust_id=" + cust_id + ", full_name=" + full_name + ", mobile=" + mobile + ", email=" + email
				+ ", bill_id=" + bill_id + ", service_id=" + service_id + ", payment_id=" + payment_id + ", address_id="
				+ address_id + "]";
	}
	
	
	

}
