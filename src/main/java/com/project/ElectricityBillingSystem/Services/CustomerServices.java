package com.project.ElectricityBillingSystem.Services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import com.project.ElectricityBillingSystem.Entity.CustomerEntity;
import com.project.ElectricityBillingSystem.Exceptions.CustomerNotFoundException;
import com.project.ElectricityBillingSystem.dto.CustDto;
import com.project.ElectricityBillingSystem.dto.RegRespDto;
import com.project.ElectricityBillingSystem.dto.RegisterDto;

@Service
public interface CustomerServices {
	
	public List<CustomerEntity> getAllCustomer();
	
	public Optional<CustomerEntity> getCustomer(int id) throws CustomerNotFoundException;
	
	public CustomerEntity addCustomer(CustomerEntity customerEntity);
	
	public Optional<CustomerEntity> deleteCustomer(int id) throws CustomerNotFoundException;
	
	public CustomerEntity updateCustomer(int id, CustomerEntity customerEntity) throws CustomerNotFoundException;

	public Optional<CustDto> getCustDtoById(int id) throws CustomerNotFoundException;

	public Optional<CustomerEntity> getCustDtoByEmail(String email);

	public RegRespDto regCustomer(@Valid RegisterDto customerEntity);

	public CustDto updateCustDtoById(int id, @Valid CustDto custDto);

	public List<CustomerEntity> get();

	

	
	
}
