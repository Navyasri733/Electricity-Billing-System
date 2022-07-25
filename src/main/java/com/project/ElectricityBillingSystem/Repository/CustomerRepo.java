package com.project.ElectricityBillingSystem.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.ElectricityBillingSystem.Entity.CustomerEntity;

@Repository
public interface CustomerRepo   extends JpaRepository<CustomerEntity,Integer>  {


	
	//@Query("select c from Customer c where c.email=: email")
	//Optional<CustomerEntity> getCustById(@Param("email") String email);

}
