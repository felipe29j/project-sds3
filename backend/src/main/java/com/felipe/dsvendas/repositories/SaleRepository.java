package com.felipe.dsvendas.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.felipe.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	
	
}