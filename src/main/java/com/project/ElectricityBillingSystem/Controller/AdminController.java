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

import com.project.ElectricityBillingSystem.Entity.AdminEntity;
import com.project.ElectricityBillingSystem.Exceptions.AdminNotFoundException;
import com.project.ElectricityBillingSystem.Services.AdminServices;


@RestController
public class AdminController {
	
	@Autowired
	private AdminServices adminServices;
	
	@GetMapping("/admin")
	public List<AdminEntity> getAllLogin() {
		return adminServices.getAllAdmin();
	}
	
	@GetMapping("admin/{id}")
	public Optional<AdminEntity> getLoginById(@PathVariable int id) throws AdminNotFoundException {
		return adminServices.getAdmin(id);
	}
	
	@PostMapping("admin")
	public AdminEntity addLogin(@Valid @RequestBody AdminEntity adminEntity) {
		return adminServices.addAdmin(adminEntity);
	}
	
	@PutMapping("admin/{id}")
	public AdminEntity updateLogin(@PathVariable int id,@Valid @RequestBody AdminEntity adminEntity) throws AdminNotFoundException {
		return adminServices.updateAdmin(id, adminEntity);
	}
	
	@DeleteMapping("admin/{id}")
	public Optional<AdminEntity> deleteLogin(@PathVariable int id) throws AdminNotFoundException {
		return adminServices.deleteAdmin(id);
	}

}
