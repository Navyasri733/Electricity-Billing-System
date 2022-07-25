package com.project.ElectricityBillingSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ElectricityBillingSystem.Entity.BillingEntity;

public interface BillingRepo extends JpaRepository<BillingEntity,Integer>{

}
