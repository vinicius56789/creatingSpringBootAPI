package com.everis.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.delivery.model.SelectedProducts;

public interface SelectedProductsRepository extends JpaRepository<SelectedProducts, Long>{

}
