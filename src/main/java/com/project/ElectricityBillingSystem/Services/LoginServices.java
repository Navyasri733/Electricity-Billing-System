package com.project.ElectricityBillingSystem.Services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.project.ElectricityBillingSystem.Entity.*;
import com.project.ElectricityBillingSystem.Exceptions.EmailNotFoundException;
import com.project.ElectricityBillingSystem.Exceptions.LoginNotFoundException;
import com.project.ElectricityBillingSystem.dto.LoginDto;
import com.project.ElectricityBillingSystem.dto.LoginRespDto;

@Service
public interface LoginServices {

	public List<LoginEntity> getAllLogin();
	
	public Optional<LoginEntity> getLogin(String email) throws LoginNotFoundException;
	
	public LoginEntity addLogin(LoginEntity loginEntity);
	
	public Optional<LoginEntity> deleteLogin(String email) throws LoginNotFoundException;
	
	public LoginEntity updateLogin(String email, LoginEntity loginEntity) throws LoginNotFoundException;

	public LoginRespDto login(@Valid LoginDto loginDto);

	public LoginRespDto logout(String email) throws EmailNotFoundException;
	
	
}
