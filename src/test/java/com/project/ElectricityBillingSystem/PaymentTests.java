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

import com.project.ElectricityBillingSystem.Entity.PaymentEntity;
import com.project.ElectricityBillingSystem.Exceptions.PaymentNotFoundException;
import com.project.ElectricityBillingSystem.Services.PaymentServiceImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PaymentTests {
	
	@Autowired
	private PaymentServiceImpl paymentServiceImpl;
	
	@Test
	void addPaymentTest() {
		
		PaymentEntity paymentEntity = new PaymentEntity(1, "cash", 1);
		PaymentEntity result = paymentServiceImpl.addPayment(paymentEntity);
		assertEquals(paymentEntity.toString(), result.toString());
	}
	
	@Test
	void getPaymentTest() {
		PaymentEntity paymentEntity = new PaymentEntity(1, "cash", 1);
		Optional<PaymentEntity> result;
		try {
			result = paymentServiceImpl.getPayment(1);
			assertEquals(paymentEntity.toString(), result.get().toString());
		} catch (PaymentNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	void updatePaymentTest() {
		PaymentEntity paymentEntity = new PaymentEntity(1, "cash", 1);
		PaymentEntity result = null;
		try {
			result = paymentServiceImpl.updatePayment(1, paymentEntity);
			if(result==null)
				throw  new PaymentNotFoundException("no payment found");
			assertEquals(paymentEntity.toString(), result.toString());
		} catch (PaymentNotFoundException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	void removePaymentTest() {
		PaymentEntity paymentEntity = new PaymentEntity(1, "cash", 1);
		Optional<PaymentEntity> result = null;
		try {
			result = paymentServiceImpl.deletePayment(1);
			if(result==null)
				throw  new PaymentNotFoundException("no payment found");
			assertEquals(paymentEntity.toString(), result.get().toString());
		} catch (PaymentNotFoundException e) {
			e.printStackTrace();
			fail();
		}
	}

}
