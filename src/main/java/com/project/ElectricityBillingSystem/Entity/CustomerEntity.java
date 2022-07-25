package com.project.ElectricityBillingSystem.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name="customer")
public class CustomerEntity {
	
	@Id
	private int id;
	
	@NotNull(message = "full_name is mandatory")
	@Size(min=3, max=10, message="Min 3 and max 10 charecters are allowed")
	private String fullName;
	
	@NotNull(message = "mobile is mandatory")
	private String mobile;
	
	@Email(message = "Email should be valid")
	@NotNull(message = "email is mandatory")
	private String email;
	
	@Positive (message = "billId should be greater than 0")
	private int billId;
	
	@Positive (message = "serviceId should be greater than 0")
	private int serviceId;
	
	@Positive (message = "paymentId should be greater than 0")
	private int paymentId;
	
	@Positive (message = "addressId should be greater than 0")
	private int addressId;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billingEntity_id")
	private BillingEntity billingEntity;
	
//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinColumn(name="customer_id")
//    private Set<AddressEntity> addressEntity;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="AddressEntity_id")
    private AddressEntity addressEntity;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "loginEntity_email")
	private LoginEntity loginEntity;
	
	public CustomerEntity() {
		super();
	}

	public CustomerEntity(int cust_id, String full_name, String mobile, String email, int bill_id, int service_id,
			int payment_id, int address_id) {
		super();
		this.id = cust_id;
		this.fullName = full_name;
		this.mobile = mobile;
		this.email = email;
		this.billId = bill_id;
		this.serviceId = service_id;
		this.paymentId = payment_id;
		this.addressId = address_id;
	}

	public int getCust_id() {
		return id;
	}

	public void setCust_id(int cust_id) {
		this.id = cust_id;
	}

	public String getFull_name() {
		return fullName;
	}

	public void setFull_name(String full_name) {
		this.fullName = full_name;
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
		return billId;
	}

	public void setBill_id(int bill_id) {
		this.billId = bill_id;
	}

	public int getService_id() {
		return serviceId;
	}

	public void setService_id(int service_id) {
		this.serviceId = service_id;
	}

	public int getPayment_id() {
		return paymentId;
	}

	public void setPayment_id(int payment_id) {
		this.paymentId = payment_id;
	}

	public int getAddress_id() {
		return addressId;
	}

	public void setAddress_id(int address_id) {
		this.addressId = address_id;
	}

	@Override
	public String toString() {
		return "CustomerEntity [cust_id=" + id + ", full_name=" + fullName + ", mobile=" + mobile + ", email="
				+ email + ", bill_id=" + billId + ", service_id=" + serviceId + ", payment_id=" + paymentId
				+ ", address_id=" + addressId + "]";
	}

	public LoginEntity getLoginEntity() {
		
		return null;
	}

	public void setLoginEntity(LoginEntity loginEntity2) {
		
		
	}

//	public BillingEntity getBillingEntity() {
//		return billingEntity;
//	}
//
//	public void setBillingEntity(BillingEntity billingEntity) {
//		this.billingEntity = billingEntity;
//	}

//	public Set<AddressEntity> getAddressEntity() {
//		return addressEntity;
//	}
//
//	public void setAddressEntity(Set<AddressEntity> addressEntity) {
//		this.addressEntity = addressEntity;
//	}
	
	
}
