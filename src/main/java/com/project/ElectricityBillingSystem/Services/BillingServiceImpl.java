package com.project.ElectricityBillingSystem.Services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ElectricityBillingSystem.Entity.BillingEntity;
import com.project.ElectricityBillingSystem.Exceptions.BillingNotFoundException;
import com.project.ElectricityBillingSystem.Repository.BillingRepo;
import com.project.ElectricityBillingSystem.Services.BillingServices;
import com.project.ElectricityBillingSystem.dto.BillingDTO;

@Service
public class BillingServiceImpl implements BillingServices{

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BillingRepo billingRepo;
	
	@Override
	public List<BillingEntity> getAllBilling() {
		// TODO Auto-generated method stub
		LOGGER.error("inside getAllBilling method");
		return billingRepo.findAll();
	}

	@Override
	public Optional<BillingEntity> getBilling(int id)  throws BillingNotFoundException {
		LOGGER.error("inside getBilling method");
		try {
			Optional<BillingEntity> billingData = billingRepo.findById(id);
			if(billingData!=null) {
				return billingRepo.findById(id);
			}
			else {
				throw new BillingNotFoundException("Billing Data not found");
			}
		}
		catch(Exception e){
			throw new BillingNotFoundException("Billing Data not found");
		
		}
	}

	@Override
	public BillingEntity addBilling(BillingDTO billingDTO) {
		LOGGER.error("inside getAdmin method");
		// TODO Auto-generated method stub
		BillingEntity billingEntity = new BillingEntity();
		billingEntity.setAmount(billingDTO.getPricePerUnit()*billingDTO.getUnitsConsumed());
		billingEntity.setCustomerId(billingDTO.getCustomerId());
		billingEntity.setDueDate(billingDTO.getDueDate());
		billingEntity.setEndDate(billingDTO.getEndDate());
		billingEntity.setId(billingDTO.getId());
		billingEntity.setStartDate(billingDTO.getStartDate());
		billingEntity.setUnitsConsumed(billingDTO.getUnitsConsumed());
		
		return billingRepo.save(billingEntity);
	}

	@Override
	public Optional<BillingEntity> deleteBilling(int id) throws BillingNotFoundException {
		LOGGER.error("inside deleteBilling method");
		try {
			Optional<BillingEntity> billingData = billingRepo.findById(id);
			if(billingData!=null) {
				billingRepo.deleteById(id);
				return billingData;
			}
			else {
				throw new BillingNotFoundException("Billing Data not found");
			}
		}
		catch(Exception e){
			throw new BillingNotFoundException("Billing Data not found");
		}
	}

	@Override
	public BillingEntity updateBilling(int id, BillingEntity billingEntity) throws BillingNotFoundException {
		LOGGER.error("inside updateBilling method");
		try {
			Optional<BillingEntity> billingData = billingRepo.findById(id);
			if(billingData!=null) {
				billingEntity.setId(id);
				return billingRepo.save(billingEntity);
			}
			else {
				throw new BillingNotFoundException("Billing Data not found");
			}
		}
		catch(Exception e){
			throw new BillingNotFoundException("Billing Data not found");
		
		}
	}
	

}
