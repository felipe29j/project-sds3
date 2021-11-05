package com.felipe.dsvendas.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.felipe.dsvendas.dto.SaleSuccessDTO;
import com.felipe.dsvendas.dto.SaleSumDTO;
import com.felipe.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	@Query("SELECT new com.felipe.dsvendas.dto.SaleSumDTO(obj.seller,SUM(obj.amount))"
			+ "FROM Sale AS obj GROUP BY obj.seller ")
	List<SaleSumDTO> amountGoupedBySeller();
	
	@Query("SELECT new com.felipe.dsvendas.dto.SaleSuccessDTO(obj.seller,SUM(obj.visited),SUM(obj.deals))"
			+ "FROM Sale AS obj GROUP BY obj.seller ")
	List<SaleSuccessDTO> successGoupedBySeller();
	
}