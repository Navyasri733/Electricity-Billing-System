package com.project.ElectricityBillingSystem.dto;

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

public class BillingDTO {
	
	private int id;
	
	private String customerId;
	
	private int unitsConsumed;
	
	private int pricePerUnit;

	private LocalDate dueDate;
	
	private LocalDate startDate;

	private LocalDate endDate;

	public BillingDTO(int id, @NotNull(message = "customerId is mandatory") String customerId,
			@Positive(message = "unitsConsumed is mandatory") int unitsConsumed,
			@Positive(message = "amount is mandatory") int pricePerUnit,
			@NotNull(message = "dueDate is mandatory") LocalDate dueDate,
			@NotNull(message = "startDate is mandatory") LocalDate startDate,
			@NotNull(message = "endDate is mandatory") LocalDate endDate) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.unitsConsumed = unitsConsumed;
		this.pricePerUnit = pricePerUnit;
		this.dueDate = dueDate;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public BillingDTO() {
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
				+ ", pricePerUnit=" + pricePerUnit + ", dueDate=" + dueDate + ", startDate=" + startDate + ", endDate=" + endDate
				+ "]";
	}

	public int getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(int pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	
//	@OneToOne(mappedBy = "billingEntity")
//	private CustomerEntity customerEntity;
	
	
}
	