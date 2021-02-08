package com.everis.delivery.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.everis.delivery.model.Product;
import com.everis.delivery.repository.ProductRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductForm {

	@NotNull
	@NotEmpty
	@Length(min = 4)
	private String nome;
	@NotNull
	private Double valor;

	public Product converter(ProductRepository productRepository) {
		return new Product(nome, valor);
	}
	
	public Product atualizar(Long id, ProductRepository productRepository) {
		Product product = productRepository.getOne(id);
		product.setNome(this.getNome());
		product.setValor(this.getValor());
		return product;
	}
}
