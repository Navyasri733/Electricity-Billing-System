package com.project.ElectricityBillingSystem.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="address")
public class AddressEntity {

	@Id
	private int id;
	
	@NotNull(message = "doorNo is mandatory")
	private String doorNo;

	@NotNull(message = "street is mandatory")
	private String street;

	@NotNull(message = "city is mandatory")
	private String city;
	
	@NotNull(message = "state is mandatory")
	private String state;
	
	@NotNull(message = "pincode is mandatory")
	private int pincode;
	
	@OneToOne(mappedBy = "addressEntity")
    private CustomerEntity customerEntity;
	
	public AddressEntity() {
		super();
	}
	public AddressEntity(int id, String d_no, String street, String city, String state) {
		super();
		this.id = id;
		this.doorNo = d_no;
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
		return "AddressEntity [id=" + id + ", d_no=" + doorNo + ", street=" + street + ", city=" + city + ", state="
				+ state + "]";
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getDno() {
		return doorNo;
	}
	public void setDno(String dno) {
		this.doorNo = dno;
	}
	
	
}
