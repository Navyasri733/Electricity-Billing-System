package com.project.ElectricityBillingSystem.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.ElectricityBillingSystem.Entity.ServiceEntity;
import com.project.ElectricityBillingSystem.Exceptions.ServiceNotFoundException;

@Service
public interface ServiceServices {

	public List<ServiceEntity> getAllService();
	
	public Optional<ServiceEntity> getService(int id) throws ServiceNotFoundException; 
	
	public ServiceEntity addService(ServiceEntity serviceEntity) throws ServiceNotFoundException;
	
	public Optional<ServiceEntity> deleteService(int id) throws ServiceNotFoundException;
	
	public ServiceEntity updateService(int id, ServiceEntity serviceEntity) throws ServiceNotFoundException;
	
}
