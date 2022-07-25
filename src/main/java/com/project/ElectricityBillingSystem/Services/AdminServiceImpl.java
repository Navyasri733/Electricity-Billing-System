package com.project.ElectricityBillingSystem.Services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ElectricityBillingSystem.Entity.AdminEntity;
import com.project.ElectricityBillingSystem.Exceptions.AdminNotFoundException;
import com.project.ElectricityBillingSystem.Repository.AdminRepo;
import com.project.ElectricityBillingSystem.Services.AdminServices;


@Service
public class AdminServiceImpl implements AdminServices {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private AdminRepo adminRepo;
	
	@Override
	public List<AdminEntity> getAllAdmin() {
		return adminRepo.findAll();
	}

	@Override
	public Optional<AdminEntity> getAdmin(int id) throws AdminNotFoundException {
		LOGGER.error("inside getAdmin method");
		try {
			Optional<AdminEntity> adminData = adminRepo.findById(id);
			if(adminData!=null) {
				return adminRepo.findById(id);
			}
			else {
				throw new AdminNotFoundException("Admin Data not found");
			}
		}
		catch(Exception e){
			throw new AdminNotFoundException("Admin Data not found");
		}	
	}

	@Override
	public AdminEntity addAdmin(AdminEntity adminEntity) {
		LOGGER.error("inside addAdmin method");
		// TODO Auto-generated method stub
		return adminRepo.save(adminEntity);
	}

	@Override
	public Optional<AdminEntity> deleteAdmin(int id) throws AdminNotFoundException {
		LOGGER.error("inside deleteAdmin method");

		try {
			Optional<AdminEntity> adminData = adminRepo.findById(id);
			if(adminData!=null) {
				adminRepo.deleteById(id);
				return adminData;
			}
			else {
				throw new AdminNotFoundException("Admin Data not found");
			}
		}
		catch(Exception e){
			throw new AdminNotFoundException("Admin Data not found");
		}
	}

	@Override
	public AdminEntity updateAdmin(int id, AdminEntity adminEntity) throws AdminNotFoundException {
		LOGGER.error("inside updateAdmin method");
		try {
			Optional<AdminEntity> adminData = adminRepo.findById(id);
			if(adminData!=null) {
				adminEntity.setId(id);
				return adminRepo.save(adminEntity);
			}
			else {
				throw new AdminNotFoundException("Admin Data not found");
			}
		}
		catch(Exception e){
			throw new AdminNotFoundException("Admin Data not found");
		}	
	}
	

}
