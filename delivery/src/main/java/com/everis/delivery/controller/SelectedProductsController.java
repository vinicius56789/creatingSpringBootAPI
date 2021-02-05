//package com.everis.delivery.controller;
//
//import javax.validation.Valid;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import com.everis.delivery.dto.SelectedProductsDto;
//import com.everis.delivery.model.SelectedProducts;
//import com.everis.delivery.repository.ShoppingRepository;
//
//public class SelectedProductsController {
//	
//	public ResponseEntity<SelectedProductsDto> cadastrarProdutos(@RequestBody @Valid SelectedProductsDto spDto, ShoppingRepository shoppingRepository){
//		SelectedProducts produtos = spDto.cadastrarProdutosSelecionados(shoppingRepository);
//		return ResponseEntity.status(HttpStatus.CREATED).body(new SelectedProductsDto(produtos));
//	}
//
//}
