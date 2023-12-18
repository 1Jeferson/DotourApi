package com.dotour.service;

import java.util.List;

import com.dotour.model.Client;

public interface ClientService {

	List<Client> getAllClients();

	Client getClientById(Long id);

	Client saveClient(Client client);

	Client updateClient(Long id, Client clientUpdate);

	void deleteById(Long id);
}
