package com.everis.delivery.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.everis.delivery.model.Client;
import com.everis.delivery.model.FormOfPayment;
import com.everis.delivery.model.SelectedProducts;
import com.everis.delivery.model.Shopping;
import com.everis.delivery.repository.ClientRepository;
import com.everis.delivery.repository.ShoppingRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class ShoppingDto {

	@Getter @Setter private Long shoppingId;
	//private Long clientId;
	@Getter @Setter private List<SelectedProducts> items;
	@Getter @Setter private FormOfPayment payment;
	@Setter private String cpf;
	@Getter @Setter private String nome;

	public ShoppingDto(Shopping shopping) {
		this.shoppingId = shopping.getId();
		this.payment = shopping.getPayment();
		//this.clientId = shopping.getClient().getId();
		this.items = shopping.getListOfPurchasedProducts();
		this.cpf = shopping.getClient().getCpf();
		this.nome = shopping.getClient().getNome();
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
		shopping.setItems(this.getItems());
		shopping.setPayment(this.getPayment());
		return shopping;
	}

}
