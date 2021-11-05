package com.felipe.dsvendas.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felipe.dsvendas.dto.SaleDTO;
import com.felipe.dsvendas.dto.SaleSuccessDTO;
import com.felipe.dsvendas.dto.SaleSumDTO;
import com.felipe.dsvendas.entities.Sale;
import com.felipe.dsvendas.repositories.SaleRepository;
import com.felipe.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerrepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerrepository.findAll();
		Page<Sale> result =  repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public 	List<SaleSumDTO> amountGoupedBySeller(){
		return repository.amountGoupedBySeller();
	}
	@Transactional(readOnly = true)
	public 	List<SaleSuccessDTO> successGoupedBySeller(){
		return repository.successGoupedBySeller();
	}

}
