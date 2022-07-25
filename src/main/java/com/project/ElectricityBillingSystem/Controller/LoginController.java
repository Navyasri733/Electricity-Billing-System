package com.project.ElectricityBillingSystem.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.ElectricityBillingSystem.Entity.LoginEntity;
import com.project.ElectricityBillingSystem.Exceptions.EmailNotFoundException;
import com.project.ElectricityBillingSystem.Exceptions.LoginNotFoundException;
import com.project.ElectricityBillingSystem.Services.LoginServices;
import com.project.ElectricityBillingSystem.dto.LoginDto;
import com.project.ElectricityBillingSystem.dto.LoginRespDto;

@RestController
@CrossOrigin
public class LoginController {
	
	@Autowired
	private LoginServices loginServices;
	
	@GetMapping("/login")
	public List<LoginEntity> getAllLogin() {
		return loginServices.getAllLogin();
	}
	
	@GetMapping("/login/{email}")
	public Optional<LoginEntity> getLoginById(@PathVariable String email) throws LoginNotFoundException {
		return loginServices.getLogin(email);
	}
	
	@PostMapping("/login")
	public LoginEntity addLogin(@Valid @RequestBody LoginEntity LoginEntity) {
		return loginServices.addLogin(LoginEntity);
	}
	
	@PostMapping("/login/dto")
	public LoginRespDto login(@Valid @RequestBody LoginDto loginDto) {
		return loginServices.login(loginDto);
	}
	
	@PutMapping("login/{email}")
	public LoginEntity updateLogin(@PathVariable String email,@Valid @RequestBody LoginEntity LoginEntity) throws LoginNotFoundException {
		return loginServices.updateLogin(email, LoginEntity);
	}
	@PatchMapping("/logout/{email}")
	public LoginRespDto logout(@PathVariable String email) throws EmailNotFoundException  {
		return loginServices.logout(email);
	} 
	@DeleteMapping("login/{email}")
	public Optional<LoginEntity> deleteLogin(@PathVariable String email) throws LoginNotFoundException {
		return loginServices.deleteLogin(email);
	}
}
