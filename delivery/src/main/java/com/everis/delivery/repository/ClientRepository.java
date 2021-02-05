package com.everis.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.everis.delivery.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

	Client findByCpf(String cpf);
}
