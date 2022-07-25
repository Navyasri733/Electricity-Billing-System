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

import com.project.ElectricityBillingSystem.Entity.ServiceEntity;
import com.project.ElectricityBillingSystem.Exceptions.ServiceNotFoundException;
import com.project.ElectricityBillingSystem.Services.ServiceServices;

@RestController
public class ServiceController {

	@Autowired
	private ServiceServices serviceServices;
	
	@GetMapping("/service")
	public List<ServiceEntity> getAllService() {
		return serviceServices.getAllService();
	}
	
	@GetMapping("service/{id}")
	public Optional<ServiceEntity> getServiceById(@PathVariable int id) throws ServiceNotFoundException {
		return serviceServices.getService(id);
	}
	
	@PostMapping("service")
	public ServiceEntity addService(@Valid @RequestBody ServiceEntity serviceEntity) throws ServiceNotFoundException {
		return serviceServices.addService(serviceEntity);
	}
	
	@PutMapping("service/{id}")
	public ServiceEntity updateService(@PathVariable int id,@Valid @RequestBody ServiceEntity serviceEntity) throws ServiceNotFoundException {
		return serviceServices.updateService(id, serviceEntity);
	}
	
	@DeleteMapping("service/{id}")
	public Optional<ServiceEntity> deleteService(@PathVariable int id) throws ServiceNotFoundException {
		return serviceServices.deleteService(id);
	}

}
