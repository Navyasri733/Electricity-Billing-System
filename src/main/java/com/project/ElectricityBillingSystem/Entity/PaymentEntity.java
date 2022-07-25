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
@Table(name="payment")
public class PaymentEntity {

	@Id
	private int id;

	@NotNull(message = "paymentType is mandatory")
	private String paymentType ;

	@Positive (message = "customerId should be greater than 0")
	private int customerId;

	
	
	public PaymentEntity() {
		super();
	}

	public PaymentEntity(int id, String payment_type, int customer_id) {
		super();
		this.id = id;
		this.paymentType = payment_type;
		this.customerId = customer_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPayment_type() {
		return paymentType;
	}

	public void setPayment_type(String payment_type) {
		this.paymentType = payment_type;
	}

	public int getCust_id() {
		return customerId;
	}

	public void setCust_id(int customer_id) {
		this.customerId = customer_id;
	}

	@Override
	public String toString() {
		return "PaymentEntity [id=" + id + ", payment_type=" + paymentType + ", customer_id=" + customerId + "]";
	}
}
