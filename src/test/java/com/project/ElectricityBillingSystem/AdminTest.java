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

import com.project.ElectricityBillingSystem.Entity.AdminEntity;
import com.project.ElectricityBillingSystem.Exceptions.AdminNotFoundException;
import com.project.ElectricityBillingSystem.Services.AdminServiceImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AdminTest {
	
	@Autowired
	private AdminServiceImpl adminServiceImpl;
	
	@Test
	void addAdminTest() {
		
		AdminEntity adminEntity = new AdminEntity(1, "admin", "8790012308");
		AdminEntity result = adminServiceImpl.addAdmin(adminEntity);
		assertEquals(adminEntity.toString(), result.toString());
	}
	
	@Test
	void getAdminTest() {
		AdminEntity adminEntity = new AdminEntity(1, "admin", "8790012308");
		Optional<AdminEntity> result;
		try {
			result = adminServiceImpl.getAdmin(1);
			assertEquals(adminEntity.toString(), result.get().toString());
		} catch (AdminNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	void updateAdminTest() {
		AdminEntity adminEntity = new AdminEntity(1, "admin", "8790012308");
		AdminEntity result = null;
		try {
			result = adminServiceImpl.updateAdmin(1, adminEntity);
			if(result==null)
				throw  new AdminNotFoundException("no admin found");
			assertEquals(adminEntity.toString(), result.toString());
		} catch (AdminNotFoundException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	void removeAdminTest() {
		AdminEntity adminEntity = new AdminEntity(1, "admin", "8790012308");
		Optional<AdminEntity> result = null;
		try {
			result = adminServiceImpl.deleteAdmin(1);
			if(result==null)
				throw  new AdminNotFoundException("no admin found");
			assertEquals(adminEntity.toString(), result.get().toString());
		} catch (AdminNotFoundException e) {
			e.printStackTrace();
			fail();
		}
	}

}
