package com.project.ElectricityBillingSystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.project.ElectricityBillingSystem.Entity.CustomerEntity;
import com.project.ElectricityBillingSystem.Exceptions.CustomerNotFoundException;
import com.project.ElectricityBillingSystem.Services.CustomerServiceImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerTests {
	
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
	@Test
	void addCustomerTest() {
		CustomerEntity customerEntity = new CustomerEntity(2,"mahender", "8790012308", "mahender@gmail.com", 1, 1, 1, 1);
		CustomerEntity result = customerServiceImpl.addCustomer(customerEntity);
		assertEquals(customerEntity.toString(), result.toString());
	}
	
	@Test
	void getCustomerTest() {
		CustomerEntity customerEntity = new CustomerEntity(2,"mahender", "8790012308", "mahender@gmail.com", 1, 1, 1, 1);
		Optional<CustomerEntity> result;
		try {
			result = customerServiceImpl.getCustomer(2);
			assertEquals(customerEntity.toString(), result.get().toString());
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	void updateCustomerTest() {
		CustomerEntity customerEntity = new CustomerEntity(2,"mahender", "8790012308", "mahender@gmail.com", 1, 1, 1, 1);
		CustomerEntity result = null;
		try {
			result = customerServiceImpl.updateCustomer(2, customerEntity);
			if(result==null)
				throw  new CustomerNotFoundException("no customer found");
			assertEquals(customerEntity.toString(), result.toString());
		} catch (CustomerNotFoundException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	void removeCustomerTest() {
		CustomerEntity customerEntity = new CustomerEntity(2,"mahender", "8790012308", "mahender@gmail.com", 1, 1, 1, 1);
		Optional<CustomerEntity> result = null;
		try {
			result = customerServiceImpl.deleteCustomer(2);
			if(result==null)
				throw  new CustomerNotFoundException("no customer found");
			assertEquals(customerEntity.toString(), result.get().toString());
		} catch (CustomerNotFoundException e) {
			e.printStackTrace();
			fail();
		}
	}
}
