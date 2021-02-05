package com.everis.delivery.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.everis.delivery.model.Product;
import com.everis.delivery.repository.ProductRepository;

public class ProductForm {

	@NotNull
	@NotEmpty
	@Length(min = 4)
	private String nome;
	@NotNull
	@NotEmpty
	@Length(min = 4)
	private Double valor;
	@NotNull
	@NotEmpty
	@Length(min = 4)
	private int quantidade;

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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

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
