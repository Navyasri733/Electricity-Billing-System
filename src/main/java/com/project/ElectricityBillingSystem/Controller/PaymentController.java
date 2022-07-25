package com.project.ElectricityBillingSystem.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.ElectricityBillingSystem.Entity.PaymentEntity;
import com.project.ElectricityBillingSystem.Exceptions.PaymentNotFoundException;
import com.project.ElectricityBillingSystem.Services.PaymentServices;

@RestController
public class PaymentController {

	@Autowired
	private PaymentServices paymentService;
	
	@GetMapping("/payment")
	public List<PaymentEntity> getAllPayment() {
		return paymentService.getAllPayment();
	}
	
	@GetMapping("payment/{id}")
	public Optional<PaymentEntity> getPaymentById(@PathVariable int id) throws PaymentNotFoundException {
		 Optional<PaymentEntity> temp =  paymentService.getPayment(id);
		 System.out.println(temp.get().toString());
		 return temp;
	}
	
	@PostMapping("payment")
	public PaymentEntity addPayment(@Valid @RequestBody PaymentEntity paymentEntity) {
		return paymentService.addPayment(paymentEntity);
	}
	
	@PutMapping("payment/{id}")
	public PaymentEntity updatePayment(@PathVariable int id,@Valid @RequestBody PaymentEntity paymentEntity) throws PaymentNotFoundException {
		return paymentService.updatePayment(id, paymentEntity);
	}
	
	@DeleteMapping("payment/{id}")
	public Optional<PaymentEntity> deletePayment(@PathVariable int id) throws PaymentNotFoundException {
		return paymentService.deletePayment(id);
	}
}
