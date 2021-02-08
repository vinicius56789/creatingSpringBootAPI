package com.everis.delivery.form;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.everis.delivery.model.Client;
import com.everis.delivery.repository.ClientRepository;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientForm {
	
	@NotNull @NotEmpty @Length(min=4)
	private String nome;
	@NotNull @NotEmpty @Length(min=4)
	private String endereco;
	@NotNull @NotEmpty @Length(min=4)
	private String telefone;
	@NotNull @NotEmpty @Length(min=4)
	private String cpf;
	
	public Client converter(ClientRepository clientRepository) {
		return new Client(nome, telefone, endereco, cpf);
	}
	
	public Client atualizar(Long id, ClientRepository clientRepository) {
		Client client = clientRepository.getOne(id);
		client.setNome(this.getNome());
		client.setTelefone(this.getTelefone());
		client.setEndereco(this.getEndereco());
		client.setCpf(this.getCpf());
		return client;
	}

}
