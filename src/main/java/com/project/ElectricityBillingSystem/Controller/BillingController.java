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

import com.project.ElectricityBillingSystem.Entity.BillingEntity;
import com.project.ElectricityBillingSystem.Exceptions.BillingNotFoundException;
import com.project.ElectricityBillingSystem.Services.BillingServices;
import com.project.ElectricityBillingSystem.dto.BillingDTO;

@RestController
public class BillingController {
	
	@Autowired
	private BillingServices billingServices;
	
	@GetMapping("/billing")
	public List<BillingEntity> getAllBilling() {
		return billingServices.getAllBilling();
	}
	
	@GetMapping("billing/{id}")
	public Optional<BillingEntity> getBillingById(@PathVariable int id) throws BillingNotFoundException {
		return billingServices.getBilling(id);
	}
	
	@PostMapping("billing")
	public BillingEntity addBilling(@Valid @RequestBody BillingDTO billingDTO) {
		return billingServices.addBilling(billingDTO);
	}
	
	@PutMapping("billing/{id}")
	public BillingEntity updateBilling(@PathVariable int id,@Valid @RequestBody BillingEntity billingEntity) throws BillingNotFoundException {
		return billingServices.updateBilling(id, billingEntity);
	}
	
	@DeleteMapping("billing/{id}")
	public Optional<BillingEntity> deleteBilling(@PathVariable int id) throws BillingNotFoundException {
		return billingServices.deleteBilling(id);
	}

}
