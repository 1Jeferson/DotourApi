package com.dotour.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotour.model.Client;
import com.dotour.repository.ClientRepository;
import com.dotour.service.ClientService;

import jakarta.transaction.Transactional;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientrepositoy;

	@Override
	public List<Client> getAllClients() {

		return clientrepositoy.findAll();
	}

	@Override
	@Transactional
	public Client getClientById(Long id) {

		return clientrepositoy.findById(id).orElse(null);
	}

	@Override
	public Client saveClient(Client client) {

		return clientrepositoy.save(client);
	}

	@Override
	public Client updateClient(Long id, Client clientUpdate) {
		Client clientExists = clientrepositoy.findById(id).orElseThrow(null);
		clientExists.setName(clientUpdate.getName());
		clientExists.setEmail(clientUpdate.getEmail());
		clientExists.setPassword(clientUpdate.getPassword());
		return clientrepositoy.save(clientExists);
	}

	@Override
	public void deleteById(Long id) {
		clientrepositoy.deleteById(id);

	}

}
