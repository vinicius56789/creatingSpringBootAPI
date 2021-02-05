package com.everis.delivery.form;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.everis.delivery.model.Client;
import com.everis.delivery.repository.ClientRepository;
import com.sun.istack.NotNull;

public class ClientForm {
	
	@NotNull @NotEmpty @Length(min=4)
	private String nome;
	@NotNull @NotEmpty @Length(min=4)
	private String endereco;
	@NotNull @NotEmpty @Length(min=4)
	private String telefone;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Client converter(ClientRepository clientRepository) {
		return new Client(nome, telefone, endereco);
	}
	
	public Client atualizar(Long id, ClientRepository clientRepository) {
		Client client = clientRepository.getOne(id);
		client.setNome(this.nome);
		client.setTelefone(this.telefone);
		client.setEndereco(this.endereco);
		return client;
	}

}
