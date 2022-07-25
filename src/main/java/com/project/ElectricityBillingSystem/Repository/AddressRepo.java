package com.project.ElectricityBillingSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ElectricityBillingSystem.Entity.AddressEntity;

@Repository
public interface AddressRepo extends JpaRepository<AddressEntity,Integer>{

}
