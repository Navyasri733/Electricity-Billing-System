package com.project.ElectricityBillingSystem.Services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ElectricityBillingSystem.Entity.LoginEntity;
import com.project.ElectricityBillingSystem.Exceptions.EmailNotFoundException;
import com.project.ElectricityBillingSystem.Exceptions.InvalidCredentialsException;
import com.project.ElectricityBillingSystem.Exceptions.LoginNotFoundException;
import com.project.ElectricityBillingSystem.Repository.LoginRepo;
import com.project.ElectricityBillingSystem.Services.LoginServices;
import com.project.ElectricityBillingSystem.dto.LoginDto;
import com.project.ElectricityBillingSystem.dto.LoginRespDto;

@Service
public class LoginServicesImpl implements LoginServices {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	public LoginRepo loginRepo;
	
	@Override
	public List<LoginEntity> getAllLogin() {
		LOGGER.error("inside get method");
		return loginRepo.findAll();
	}

	@Override
	public Optional<LoginEntity> getLogin(String email) throws LoginNotFoundException {

		LOGGER.error("inside getLogin method");
		try {
			Optional<LoginEntity> loginData = loginRepo.findById(email);
			if(loginData!=null) {
				return loginRepo.findById(email);
			}
			else {
				throw new LoginNotFoundException("login Data not found");
			}
		}
		catch(Exception e){
			throw new LoginNotFoundException("login Data not found");
		}
	}

	@Override
	public LoginEntity addLogin(LoginEntity loginEntity) {
		LOGGER.error("inside addLogin method");
		
		return loginRepo.save(loginEntity);
	}

	@Override
	public Optional<LoginEntity> deleteLogin(String email) throws LoginNotFoundException {
		LOGGER.error("inside deleteLogin method");
		try {
			Optional<LoginEntity> loginData = loginRepo.findById(email);
			if(loginData!=null) {
				loginRepo.deleteById(email);
				return loginData;
			}
			else {
				throw new LoginNotFoundException("login Data not found");
			}
		}
		catch(Exception e){
			throw new LoginNotFoundException("login Data not found");
		}
	}

	@Override
	public LoginEntity updateLogin(String email, LoginEntity loginEntity) throws LoginNotFoundException {
		LOGGER.error("inside updateLogin method");
		try {
			Optional<LoginEntity> loginData = loginRepo.findById(email);
			if(loginData!=null) {
				loginEntity.setEmail(email);
				return loginRepo.save(loginEntity);
			}
			else {
				throw new LoginNotFoundException("login Data not found");
			}
		}
		catch(Exception e){
			throw new LoginNotFoundException("login Data not found");
		}
	}

	@Override
	public LoginRespDto login(LoginDto loginDto) {
		LOGGER.error("inside login method");
		
		Optional<LoginEntity> loginData = loginRepo.findById(loginDto.getEmail());
		if (loginData.isPresent()) { 
			
			// compare db password with user provided password
		    // if password matching return credentials else throw exception
			LoginEntity loginEntity = loginData.get();
			if(loginEntity.getPassword().equals(loginDto.getPassword())
					&& loginEntity.getRole().equals(loginDto.getRole())) {
				
				// if credentials matches, set loggedIn flag as true and save
				 loginEntity.setLoggedIn(true);
				 LoginEntity updatedLogin = loginRepo.save(loginEntity);
				 
				// convert Login to LoginRespDto Obj
					LoginRespDto resDto = new LoginRespDto();
					resDto.setEmail(loginEntity.getEmail());
					resDto.setRole(loginEntity.getRole());
					resDto.setLoggedIn(loginEntity.isLoggedIn());
					return resDto;
					
			} else {
				throw new InvalidCredentialsException("Invalid credentials!");
			}
		} else {
			// throw exception if given email not present in the db.
			throw new InvalidCredentialsException("User not found with email: "+loginDto.getEmail());
		}
	}

	@Override
	public LoginRespDto logout(String email) throws EmailNotFoundException {
		Optional<LoginEntity> loginData = loginRepo.findById(email);
		if(loginData.isPresent()) {
			
			// update isLoggedIn flag as false and save
			LoginEntity loginEntity = loginData.get();
			
			// Update flag to false and save
			 loginEntity.setLoggedIn(false);
			 LoginEntity updatedLogin = loginRepo.save(loginEntity);
						
			// Convert Login obj to LoginRespDto
			LoginRespDto resDto = new LoginRespDto();
			
			resDto.setLoggedIn(false);
			
			// return LoginRespDto obj
		   return resDto;
			
		} else {
			throw new EmailNotFoundException("User not found with email: "+email);
					}
	}
}
