package com.everis.delivery.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "shopping")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shopping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(mappedBy = "shopping")
	private List<SelectedProducts> items;
	@ManyToOne
	private Client client;
	@Enumerated(EnumType.STRING)
	private FormOfPayment payment;

	public Shopping(Client client, List<SelectedProducts> produtos, FormOfPayment payment2) {
		this.client = client;
		this.items = produtos;
		this.payment = payment2;
	}
	
	public List<SelectedProducts> getListOfPurchasedProducts() {
		if(items == null) {
			items = new ArrayList<SelectedProducts>();
		}
		return items;
	}

}
