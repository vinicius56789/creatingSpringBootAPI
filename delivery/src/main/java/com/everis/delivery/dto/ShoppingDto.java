package com.everis.delivery.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.everis.delivery.model.Client;
import com.everis.delivery.model.FormOfPayment;
import com.everis.delivery.model.SelectedProducts;
import com.everis.delivery.model.Shopping;
import com.everis.delivery.repository.ClientRepository;
import com.everis.delivery.repository.ShoppingRepository;

public class ShoppingDto {

	private Long shoppingId;
	private Long clientId;
	private List<SelectedProducts> items;
	private FormOfPayment payment;
	private String cpf;
	

	public ShoppingDto(Shopping shopping) {
		this.shoppingId = shopping.getId();
		this.payment = shopping.getPayment();
		this.clientId = shopping.getClient().getId();
		this.items = shopping.getListOfPurchasedProducts();
		this.cpf = shopping.getClient().getCpf();
	}

	public ShoppingDto() {
	}
	
	public Long getShoppingId() {
		return shoppingId;
	}

	public void setShoppingId(Long shoppingId) {
		this.shoppingId = shoppingId;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public FormOfPayment getPayment() {
		return payment;
	}

	public void setPayment(FormOfPayment payment) {
		this.payment = payment;
	}

	public List<SelectedProducts> getItems() {
		return items;
	}

	public void setItems(List<SelectedProducts> items) {
		this.items = items;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public static List<ShoppingDto> converter(List<Shopping> compras) {
		return compras.stream().map(ShoppingDto::new).collect(Collectors.toList());
	}

	public Shopping CadastrarShopping(ClientRepository clientRepository) {
		Client client = clientRepository.findByCpf(cpf);
		return new Shopping(client, items, payment);
	}

	public Shopping atualizar(Long id, ShoppingRepository shoppingRepository) {
		Shopping shopping = shoppingRepository.getOne(id);
		shopping.setListOfPurchasedProducts(this.getItems());
		shopping.setPayment(this.getPayment());
		return shopping;
	}

}
