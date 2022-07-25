package com.project.ElectricityBillingSystem.Entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="billing")
public class BillingEntity {
	
	@Id
	private int id;
	
	@NotNull(message = "customerId is mandatory")
	private String customerId;
	
	@Positive (message = "unitsConsumed is mandatory")
	private int unitsConsumed;
	
	@Positive (message = "amount is mandatory")
	private int amount;
	
	@NotNull(message = "dueDate is mandatory")
	private LocalDate dueDate;
	
	@NotNull(message = "startDate is mandatory")
	private LocalDate startDate;

	@NotNull(message = "endDate is mandatory")
	private LocalDate endDate;
	
	@OneToOne(mappedBy = "billingEntity")
	private CustomerEntity customerEntity;

	public BillingEntity(int id,String customerId,int unitsConsumed,int amount,LocalDate dueDate,LocalDate startDate,LocalDate endDate) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.unitsConsumed = unitsConsumed;
		this.amount = amount;
		this.dueDate = dueDate;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public BillingEntity() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public int getUnitsConsumed() {
		return unitsConsumed;
	}

	public void setUnitsConsumed(int unitsConsumed) {
		this.unitsConsumed = unitsConsumed;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "BillingEntity [id=" + id + ", customerId=" + customerId + ", unitsConsumed=" + unitsConsumed
				+ ", amount=" + amount + ", dueDate=" + dueDate + ", startDate=" + startDate + ", endDate=" + endDate
				+ "]";
	}
	

	
	
}
	