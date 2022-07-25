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

import com.project.ElectricityBillingSystem.Entity.AddressEntity;
import com.project.ElectricityBillingSystem.Exceptions.AddressNotFoundException;
import com.project.ElectricityBillingSystem.Services.AddressServicesImple;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AddressTests {
	
	@Autowired
	private AddressServicesImple addressServicesImple;
	
	@Test
	void addAddressTest() {
		
		AddressEntity addressEntity = new AddressEntity(1, "123","downtown", "hyderabad", "telangana");
		AddressEntity result = addressServicesImple.addAddress(addressEntity);
		assertEquals(addressEntity.toString(), result.toString());
	}
	
	@Test
	void getAddressTest() {
		AddressEntity addressEntity = new AddressEntity(3, "4-5","ns nagar", "ss city", "TG");
		Optional<AddressEntity> result;
		try {
			result = addressServicesImple.getAddress(3);
			assertEquals(addressEntity.toString(), result.get().toString());
		} catch (AddressNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	void updateAddressTest() {
		AddressEntity addressEntity = new AddressEntity(1, "123","downtown", "hyderabad", "telangana");
		AddressEntity result = null;
		try {
			result = addressServicesImple.updateAddress(1, addressEntity);
			if(result==null)
				throw  new AddressNotFoundException("no address found");
			assertEquals(addressEntity.toString(), result.toString());
		} catch (AddressNotFoundException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	void removeAddressTest() {
		AddressEntity addressEntity = new AddressEntity(1, "123","downtown", "hyderabad", "telangana");
		Optional<AddressEntity> result = null;
		try {
			result = addressServicesImple.deleteAddress(1);
			if(result==null)
				throw  new AddressNotFoundException("no address found");
			assertEquals(addressEntity.toString(), result.get().toString());
		} catch (AddressNotFoundException e) {
			e.printStackTrace();
			fail();
		}
	}

}
