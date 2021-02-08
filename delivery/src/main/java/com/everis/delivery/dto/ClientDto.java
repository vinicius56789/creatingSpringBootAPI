package com.everis.delivery.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.everis.delivery.model.Client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

	private Long id;
	private String nome;
	private String telefone;
	private String endereco;

	public ClientDto(Client client) {
		this.id = client.getId();
		this.nome = client.getNome();
		this.telefone = client.getTelefone();
		this.endereco = client.getEndereco();
	}

	public static List<ClientDto> converter(List<Client> clients) {
		return clients.stream().map(ClientDto::new).collect(Collectors.toList());
	}

}
