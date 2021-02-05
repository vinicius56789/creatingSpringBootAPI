package com.everis.delivery.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.delivery.dto.ProductDto;
import com.everis.delivery.form.ProductForm;
import com.everis.delivery.model.Product;
import com.everis.delivery.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;

	@GetMapping
	public List<ProductDto> listarTodosProduct(){
		List<Product> product = productRepository.findAll();
		return ProductDto.converter(product);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<ProductDto> cadastrarProduct(@RequestBody @Valid ProductForm form){
		Product product = form.converter(productRepository);
		productRepository.save(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDto(product));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> listarIdProduct(@PathVariable Long id){
		Optional<Product> optional = productRepository.findById(id);
		if(optional.isPresent()) {
			return ResponseEntity.ok(new ProductDto(optional.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProductDto> UpdateProduct(@PathVariable Long id, @RequestBody @Valid ProductForm form){
		Optional<Product> optional = productRepository.findById(id);
		if(optional.isPresent()) {
			Product product = form.atualizar(id, productRepository);
			return ResponseEntity.ok(new ProductDto(product));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<ProductDto> deleteProduct(@PathVariable Long id){
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()) {
			productRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.ok().build();
	}
	
}
