package com.project.ElectricityBillingSystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.project.ElectricityBillingSystem.Entity.BillingEntity;
import com.project.ElectricityBillingSystem.Exceptions.BillingNotFoundException;
import com.project.ElectricityBillingSystem.Services.BillingServiceImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BillingTests {
	

	@Autowired
	private BillingServiceImpl billingServiceImpl;
	
	
	
	@Test
	void getBillingTest() {
		BillingEntity billingEntity = new BillingEntity(1, "1", 120, 1000, LocalDate.of( 2012 , 12 , 7 ), LocalDate.of( 2012 , 12 , 7 ),LocalDate.of( 2012 , 12 , 7 ));
		Optional<BillingEntity> result;
		try {
			result = billingServiceImpl.getBilling(1);
			assertEquals(billingEntity.toString(), result.get().toString());
		} catch (BillingNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	void updateBillingTest() {
		BillingEntity billingEntity = new BillingEntity(1, "1", 120, 1000, LocalDate.of( 2012 , 12 , 7 ), LocalDate.of( 2012 , 12 , 7 ),LocalDate.of( 2012 , 12 , 7 ));
		BillingEntity result = null;
		try {
			result = billingServiceImpl.updateBilling(1, billingEntity);
			if(result==null)
				throw  new BillingNotFoundException("no billing found");
			assertEquals(billingEntity.toString(), result.toString());
		} catch (BillingNotFoundException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	void removeBillingTest() {
		BillingEntity billingEntity = new BillingEntity(1, "1", 120, 1000, LocalDate.of( 2012 , 12 , 7 ), LocalDate.of( 2012 , 12 , 7 ),LocalDate.of( 2012 , 12 , 7 ));
		Optional<BillingEntity> result = null;
		try {
			result = billingServiceImpl.deleteBilling(1);
			if(result==null)
				throw  new BillingNotFoundException("no billing found");
			assertEquals(billingEntity.toString(), result.get().toString());
		} catch (BillingNotFoundException e) {
			e.printStackTrace();
			fail();
		}
	}

}
