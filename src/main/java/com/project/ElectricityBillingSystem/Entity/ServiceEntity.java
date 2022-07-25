package com.project.ElectricityBillingSystem.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@Entity
@Table(name="Service")
public class ServiceEntity {
	
	@Id
	private int id;
	
	@NotNull(message = "serviceType is mandatory")
	private String serviceType ;
	
	@Positive (message = "custId should be greater than 0")
	private int custId;

	
	
	public ServiceEntity() {
		super();
	}

	public ServiceEntity(int id, String service_type, int cust_id) {
		super();
		this.id = id;
		this.serviceType = service_type;
		this.custId = cust_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getService_type() {
		return serviceType;
	}

	public void setService_type(String service_type) {
		this.serviceType = service_type;
	}

	public int getCust_id() {
		return custId;
	}

	public void setCust_id(int cust_id) {
		this.custId = cust_id;
	}

	@Override
	public String toString() {
		return "ServiceEntity [id=" + id + ", service_type=" + serviceType + ", cust_id=" + custId + "]";
	}
	
	
	
}
