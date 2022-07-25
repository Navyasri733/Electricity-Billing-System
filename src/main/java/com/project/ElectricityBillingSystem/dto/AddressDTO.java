package com.project.ElectricityBillingSystem.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AddressDTO {
        private int id;
        private String d_no;
        private String street;
        private String city;
        private String state;
        private String pinCode;

	public AddressDTO() {
		super();
	}

	public AddressDTO(int id, String d_no, String street, String city, String state) {
		super();
		this.id = id;
		this.d_no = d_no;
		this.street = street;
		this.city = city;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getD_no() {
		return d_no;
	}

	public void setD_no(String d_no) {
		this.d_no = d_no;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "AddressEntity [id=" + id + ", d_no=" + d_no + ", street=" + street + ", city=" + city + ", state="
				+ state + "]";
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

}
