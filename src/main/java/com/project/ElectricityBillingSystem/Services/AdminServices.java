package com.project.ElectricityBillingSystem.Services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.ElectricityBillingSystem.Entity.AdminEntity;
import com.project.ElectricityBillingSystem.Exceptions.AdminNotFoundException;


@Service
public interface AdminServices {

	public List<AdminEntity> getAllAdmin();
	
	public Optional<AdminEntity> getAdmin(int id) throws AdminNotFoundException;
	
	public AdminEntity addAdmin(AdminEntity adminEntity);
	
	public Optional<AdminEntity> deleteAdmin(int id) throws AdminNotFoundException;
	
	public AdminEntity updateAdmin(int id, AdminEntity adminEntity) throws AdminNotFoundException;
	
}
