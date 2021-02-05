package com.everis.delivery.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.delivery.dto.ClientDto;
import com.everis.delivery.form.ClientForm;
import com.everis.delivery.model.Client;
import com.everis.delivery.repository.ClientRepository;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping
	public List<ClientDto> listarTodosClient(){
		List<Client> clients = clientRepository.findAll();
		return ClientDto.converter(clients);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<ClientDto> cadastrarClient(@RequestBody @Valid ClientForm form){
		Client client = form.converter(clientRepository);
		clientRepository.save(client);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ClientDto(client));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClientDto> listarIdClient(@PathVariable("id") Long id){
		Optional<Client> client = clientRepository.findById(id);
		if(client.isPresent()) {
			return ResponseEntity.ok(new ClientDto(client.get()));
		}
		return ResponseEntity.notFound().build();	
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ClientDto> updateClient(@PathVariable Long id, @RequestBody @Valid ClientForm form){
		Optional<Client> optional = clientRepository.findById(id);
		if(optional.isPresent()) {
			Client client = form.atualizar(id, clientRepository);
			return ResponseEntity.ok(new ClientDto(client));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("{id}")
	@Transactional
	public ResponseEntity<?> deleteClient(@PathVariable Long id){
		Optional<Client> optional = clientRepository.findById(id);
		if(optional.isPresent()) {
			clientRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
