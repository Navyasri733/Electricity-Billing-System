package com.project.ElectricityBillingSystem.Services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ElectricityBillingSystem.Entity.CustomerEntity;
import com.project.ElectricityBillingSystem.Entity.LoginEntity;
import com.project.ElectricityBillingSystem.Exceptions.CustomerNotFoundException;
import com.project.ElectricityBillingSystem.Repository.CustomerRepo;
import com.project.ElectricityBillingSystem.Services.CustomerServices;
import com.project.ElectricityBillingSystem.dto.CustDto;
import com.project.ElectricityBillingSystem.dto.RegRespDto;
import com.project.ElectricityBillingSystem.dto.RegisterDto;

@Service
public class CustomerServiceImpl implements CustomerServices {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	public CustomerRepo customerRepo;
	
	@Override
	public List<CustomerEntity> get() {
		LOGGER.error("inside get method");
		return customerRepo.findAll();
	}
		
	@Override
	public List<CustomerEntity> getAllCustomer() {
		LOGGER.error("inside getAllCustomer method");
		return customerRepo.findAll();
	}

	@Override
	public Optional<CustomerEntity> getCustomer(int id) throws CustomerNotFoundException {
		LOGGER.error("inside getCustomer method");
		try {
			Optional<CustomerEntity> customerData = customerRepo.findById(id);
			if(customerData!=null) {
				return customerRepo.findById(id);
			}
			else {
				throw new CustomerNotFoundException("Customer Data not found");
			}
		}
		catch(Exception e){
			throw new CustomerNotFoundException("Customer Data not found");
		}
	}

	@Override
	public CustomerEntity addCustomer(CustomerEntity customerEntity) {
		LOGGER.error("inside addCustomer method");
		return customerRepo.save(customerEntity);
	}

	@Override
	public Optional<CustomerEntity> deleteCustomer(int id) throws CustomerNotFoundException {
		LOGGER.error("inside deleteCustomer method");
		try {
			Optional<CustomerEntity> customerData = customerRepo.findById(id);
			if(customerData!=null) {
				customerRepo.deleteById(id);
				return customerData;
			}
			else {
				throw new CustomerNotFoundException("Customer Data not found");
			}
		}
		catch(Exception e){
			throw new CustomerNotFoundException("Customer Data not found");
		}
	}

	@Override
	public CustomerEntity updateCustomer(int id, CustomerEntity customerEntity) throws CustomerNotFoundException {
		LOGGER.error("inside updateCustomer method");
		try {
			Optional<CustomerEntity> customerData = customerRepo.findById(id);
			if(customerData!=null) {
				customerEntity.setCust_id(id);
				return customerRepo.save(customerEntity);
			}
			else {
				throw new CustomerNotFoundException("Customer Data not found");
			}
		}
		catch(Exception e){
			throw new CustomerNotFoundException("Customer Data not found");
		
		}	
		
	}

	@Override
	public Optional<CustDto> getCustDtoById(int id) throws CustomerNotFoundException {
		LOGGER.error("inside getCustDtoById method");
		try {
	         Optional<CustomerEntity> customerData = customerRepo.findById(id);
		     if (customerData.isPresent()) {
			    CustomerEntity customerEntity = customerRepo.getById(id);
			    
			// convert customerEntity to custDto object
			    
			    CustDto custDto = new CustDto();
			    custDto.setCust_id(customerEntity.getCust_id());
			    custDto.setFull_name(customerEntity.getFull_name());
			    custDto.setMobile(customerEntity.getMobile());
			    custDto.setEmail(customerEntity.getEmail());
			    custDto.setBill_id(customerEntity.getBill_id());
			    custDto.setService_id(customerEntity.getService_id());
			    custDto.setPayment_id(customerEntity.getPayment_id());
			    custDto.setAddress_id(customerEntity.getAddress_id());
			    
			    LoginEntity loginEntity = customerEntity.getLoginEntity();
			    loginEntity.setEmail(custDto.getEmail());
			    customerEntity.setLoginEntity(loginEntity);
			    customerRepo.save(customerEntity);
			    return Optional.of(custDto);
		} else {
			throw new  CustomerNotFoundException("Customer not found with customer id"+ id);
		}
		}
		catch(Exception e){
			throw new CustomerNotFoundException("Customer not found with customer id"+ id);
		
		}	
		
	}
	

	@Override
	public Optional<CustomerEntity> getCustDtoByEmail(String email) {
		LOGGER.error("inside getCustDtoByEmail method");
		return Optional.empty();
	}

	@Override
	public RegRespDto regCustomer(@Valid RegisterDto customerEntity) {
		LOGGER.error("inside regCustomer method");
		return null;
	}

	@Override
	public CustDto updateCustDtoById(int id, @Valid CustDto custDto) {
		LOGGER.error("inside updateCustDtoById method");
		return null;
	}

	
}
