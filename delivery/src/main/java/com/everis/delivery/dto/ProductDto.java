package com.everis.delivery.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.everis.delivery.model.Product;

public class ProductDto {

	public String nome;
	public Double valor;

	public ProductDto(Product product) {
		this.nome = product.getNome();
		this.valor = product.getValor();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public static List<ProductDto> converter(List<Product> products) {
		return products.stream().map(ProductDto::new).collect(Collectors.toList());
	}

}
