package com.project.ElectricityBillingSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ElectricityBillingSystem.Entity.PaymentEntity;

@Repository
public interface PaymentRepo  extends JpaRepository<PaymentEntity,Integer>{

}
