package com.everis.delivery.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class SelectedProducts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JsonIgnore
	@Getter @Setter private Shopping shopping;
	@ManyToOne
	@Getter @Setter private Product product;
	@Getter @Setter private int quantidade;

	public SelectedProducts(Long id2, Product product, int quantidade2) {
		this.shopping.setId(id2);
		this.product = product;
		this.quantidade = quantidade2;
	}

}
