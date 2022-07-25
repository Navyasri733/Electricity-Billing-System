package com.project.ElectricityBillingSystem.Services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ElectricityBillingSystem.Entity.PaymentEntity;
import com.project.ElectricityBillingSystem.Exceptions.PaymentNotFoundException;
import com.project.ElectricityBillingSystem.Repository.PaymentRepo;
import com.project.ElectricityBillingSystem.Services.PaymentServices;

@Service
public class PaymentServiceImpl implements PaymentServices{
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private PaymentRepo paymentRepo;
	
	@Override
	public List<PaymentEntity> getAllPayment() {
		LOGGER.error("inside getAllPayment method");
		// TODO Auto-generated method stub
		return paymentRepo.findAll();
	}

	@Override
	public Optional<PaymentEntity> getPayment(int id) throws PaymentNotFoundException {
		// TODO Auto-generated method stub
		LOGGER.error("inside getPayment method");
		try {
			Optional<PaymentEntity> paymentData = paymentRepo.findById(id);
			if(paymentData!=null) {
				return paymentRepo.findById(id);
			}
			else {
				throw new PaymentNotFoundException("Payment Data not found");
			}
		}
		catch(Exception e){
			throw new PaymentNotFoundException("Payment Data not found");
		
		}	
	}

	@Override
	public PaymentEntity addPayment(PaymentEntity paymentEntity) {
		// TODO Auto-generated method stub
		LOGGER.error("inside addPayment method");
		return paymentRepo.save(paymentEntity);

	}

	@Override
	public Optional<PaymentEntity> deletePayment(int id) throws PaymentNotFoundException {
		LOGGER.error("inside deletePayment method");
		try {
			Optional<PaymentEntity> paymentData = paymentRepo.findById(id);
			if(paymentData!=null) {
				paymentRepo.deleteById(id);
				return paymentData;
			}
			else {
				throw new PaymentNotFoundException("Payment Data not found");
			}
		}
		catch(Exception e){
			throw new PaymentNotFoundException("Payment Data not found");
		}
	}

	@Override
	public PaymentEntity updatePayment(int id, PaymentEntity paymentEntity) throws PaymentNotFoundException {
		LOGGER.error("inside updatePayment method");
		try {
			Optional<PaymentEntity> paymentData = paymentRepo.findById(id);
			if(paymentData!=null) {
				paymentEntity.setId(id);
				return paymentRepo.save(paymentEntity);
			}
			else {
				throw new PaymentNotFoundException("Payment Data not found");
			}
		}
		catch(Exception e){
			throw new PaymentNotFoundException("Payment Data not found");
		
		}	
	}

}
