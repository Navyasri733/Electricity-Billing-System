package com.project.ElectricityBillingSystem.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="admin")
public class AdminEntity {
	
	@Id
	private int id;
	
	@NotNull(message = "adminName is mandatory")
	private String adminName;
	
	@NotNull(message = "admin_contact is mandatory")
	private String adminContact;
	
	public AdminEntity() {
		super();
	}
	public AdminEntity(int id, String admin_name, String admin_contact) {
		super();
		this.id = id;
		this.adminName = admin_name;
		this.adminContact = admin_contact;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "AdminEntity [id=" + id + ", admin_name=" + adminName + ", admin_contact=" + adminContact + "]";
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminContact() {
		return adminContact;
	}
	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}
	
	
}
