package com.project.ElectricityBillingSystem.Services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ElectricityBillingSystem.Entity.ServiceEntity;
import com.project.ElectricityBillingSystem.Exceptions.ServiceNotFoundException;
import com.project.ElectricityBillingSystem.Repository.ServiceRepo;
import com.project.ElectricityBillingSystem.Services.ServiceServices;

@Service
public class ServiceServiceImpl implements ServiceServices {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ServiceRepo serviceRepo;
	
	@Override
	public List<ServiceEntity> getAllService() {
		LOGGER.error("inside getAllService method");
		// TODO Auto-generated method stub
		return serviceRepo.findAll();
	}

	@Override
	public Optional<ServiceEntity> getService(int id) throws ServiceNotFoundException {
		LOGGER.error("inside getService method");
		// TODO Auto-generated method stub
		try {
			Optional<ServiceEntity> serviceData = serviceRepo.findById(id);
			if(serviceData!=null) {
				return serviceRepo.findById(id);
			}
			else {
				throw new ServiceNotFoundException("Service Data not found");
			}
		}
		catch(Exception e){
			throw new ServiceNotFoundException("Service Data not found");
		
		}	
	}

	@Override
	public ServiceEntity addService(ServiceEntity serviceEntity) {
		LOGGER.error("inside addService method");
		// TODO Auto-generated method stub
		return serviceRepo.save(serviceEntity);
	}

	@Override
	public Optional<ServiceEntity> deleteService(int id) throws ServiceNotFoundException {
		LOGGER.error("inside deleteService method");
		try {
			Optional<ServiceEntity> serviceData = serviceRepo.findById(id);
			if(serviceData!=null) {
				serviceRepo.deleteById(id);
				return serviceData;
			}
			else {
				throw new ServiceNotFoundException("Service Data not found");
			}
		}
		catch(Exception e){
			throw new ServiceNotFoundException("Service Data not found");
		}
	}

	@Override
	public ServiceEntity updateService(int id, ServiceEntity serviceEntity) throws ServiceNotFoundException {
		LOGGER.error("inside updateService method");
		try {
			Optional<ServiceEntity> serviceData = serviceRepo.findById(id);
			if(serviceData!=null) {
				serviceEntity.setId(id);
				return serviceRepo.save(serviceEntity);
			}
			else {
				throw new ServiceNotFoundException("Service Data not found");
			}
		}
		catch(Exception e){
			throw new ServiceNotFoundException("Service Data not found");
		
		}	
	}

}
