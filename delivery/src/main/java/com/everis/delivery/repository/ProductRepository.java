package com.everis.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.delivery.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
