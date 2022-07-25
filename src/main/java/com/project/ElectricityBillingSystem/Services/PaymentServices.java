package com.project.ElectricityBillingSystem.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.ElectricityBillingSystem.Entity.PaymentEntity;
import com.project.ElectricityBillingSystem.Exceptions.PaymentNotFoundException;

@Service
public interface PaymentServices {
	
	public List<PaymentEntity> getAllPayment();
		
	public Optional<PaymentEntity> getPayment(int id) throws PaymentNotFoundException ;
	
	public PaymentEntity addPayment(PaymentEntity paymentEntity);
	
	public Optional<PaymentEntity> deletePayment(int id) throws PaymentNotFoundException ;
	
	public PaymentEntity updatePayment(int id, PaymentEntity paymentEntity) throws PaymentNotFoundException;
}
