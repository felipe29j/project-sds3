package com.felipe.dsvendas.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.felipe.dsvendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

}
