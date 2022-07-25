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

import com.project.ElectricityBillingSystem.Entity.AddressEntity;
import com.project.ElectricityBillingSystem.Exceptions.AddressNotFoundException;
import com.project.ElectricityBillingSystem.Services.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	private AddressService addressServices;
	
	@GetMapping("/address")
	public List<AddressEntity> getAllAddress() {
		return addressServices.getAllAddress();
	}
	
	@GetMapping("address/{id}")
	public Optional<AddressEntity> getAddressById(@PathVariable int id) throws AddressNotFoundException {
		
		return addressServices.getAddress(id);
	}
	
	@PostMapping("address")
	public AddressEntity addAddress(@Valid @RequestBody AddressEntity addressEntity) {
		return addressServices.addAddress(addressEntity);
	}
	
	@PutMapping("address/{id}")
	public AddressEntity updateAddress(@PathVariable int id,@Valid @RequestBody AddressEntity addressEntity) throws AddressNotFoundException {
		return addressServices.updateAddress(id, addressEntity);
	}
	
	@DeleteMapping("address/{id}")
	public Optional<AddressEntity> deleteAddress(@PathVariable int id) throws AddressNotFoundException{
		return addressServices.deleteAddress(id);
	}


}
