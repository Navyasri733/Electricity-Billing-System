package com.project.ElectricityBillingSystem.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

public class AdminDTO {
	private int id;
	private String admin_name;
	private String admin_contact;
	
	public AdminDTO() {
		super();
	}
	public AdminDTO(int id, String admin_name, String admin_contact) {
		super();
		this.id = id;
		this.admin_name = admin_name;
		this.admin_contact = admin_contact;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_contact() {
		return admin_contact;
	}
	public void setAdmin_contact(String admin_contact) {
		this.admin_contact = admin_contact;
	}
	@Override
	public String toString() {
		return "AdminEntity [id=" + id + ", admin_name=" + admin_name + ", admin_contact=" + admin_contact + "]";
	}
	
	
}
