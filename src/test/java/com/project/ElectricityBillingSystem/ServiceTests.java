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

import com.project.ElectricityBillingSystem.Entity.ServiceEntity;
import com.project.ElectricityBillingSystem.Exceptions.ServiceNotFoundException;
import com.project.ElectricityBillingSystem.Services.ServiceServiceImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ServiceTests {
	
	@Autowired
	private ServiceServiceImpl serviceServiceImpl;

	@Test
	void addServiceTest() {
		
		ServiceEntity serviceEntity = new ServiceEntity(1, "phase-1", 1);
		ServiceEntity result = serviceServiceImpl.addService(serviceEntity);
		assertEquals(serviceEntity.toString(), result.toString());
	}
	
	@Test
	void getServiceTest() {
		ServiceEntity serviceEntity = new ServiceEntity(1, "phase-1", 1);
		Optional<ServiceEntity> result;
		try {
			result = serviceServiceImpl.getService(1);
			assertEquals(serviceEntity.toString(), result.get().toString());
		} catch (ServiceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	void updateServiceTest() {
		ServiceEntity serviceEntity = new ServiceEntity(1, "phase-1", 1);
		ServiceEntity result = null;
		try {
			result = serviceServiceImpl.updateService(1, serviceEntity);
			assertEquals(serviceEntity.toString(), result.toString());
			if(result==null)
				throw  new ServiceNotFoundException("no service found");
		} catch (ServiceNotFoundException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	void removeServiceTest() {
		ServiceEntity serviceEntity = new ServiceEntity(1, "phase-1", 1);
		Optional<ServiceEntity> result = null;
		try {
			result = serviceServiceImpl.deleteService(1);
			if(result==null)
				throw  new ServiceNotFoundException("no service found");
			assertEquals(serviceEntity.toString(), result.get().toString());
		} catch (ServiceNotFoundException e) {
			e.printStackTrace();
			fail();
		}
	}
}
