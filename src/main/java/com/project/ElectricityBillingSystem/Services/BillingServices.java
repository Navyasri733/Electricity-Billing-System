package com.project.ElectricityBillingSystem.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.project.ElectricityBillingSystem.Entity.BillingEntity;
import com.project.ElectricityBillingSystem.Exceptions.BillingNotFoundException;
import com.project.ElectricityBillingSystem.dto.BillingDTO;

@Service
public interface BillingServices {

	public List<BillingEntity> getAllBilling();
	
	public Optional<BillingEntity> getBilling(int id) throws BillingNotFoundException;
	
	public BillingEntity addBilling(BillingDTO billingDTO);
	
	public Optional<BillingEntity> deleteBilling(int id) throws BillingNotFoundException;
	
	public BillingEntity updateBilling(int id, BillingEntity billingEntity) throws BillingNotFoundException;
}
