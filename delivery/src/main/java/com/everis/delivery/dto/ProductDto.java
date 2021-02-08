package com.everis.delivery.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.everis.delivery.model.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

	public String nome;
	public Double valor;

	public ProductDto(Product product) {
		this.nome = product.getNome();
		this.valor = product.getValor();
	}

	public static List<ProductDto> converter(List<Product> products) {
		return products.stream().map(ProductDto::new).collect(Collectors.toList());
	}

}
