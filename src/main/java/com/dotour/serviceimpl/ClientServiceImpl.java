package com.dotour.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotour.model.Client;
import com.dotour.repository.ClientRepository;
import com.dotour.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	
	@Autowired
	private ClientRepository clientrepositoy;
	
	
	@Override
	public List<Client> getAllClients() {
	
		return clientrepositoy.findAll();
	}

	@Override
	public Client getClientById(Long id) {
		
		return clientrepositoy.findById(id).orElseThrow(() -> new RuntimeException("ID: " + id + "Not Found"));
	}

	@Override
	public Client saveClient(Client client) {
		
		return clientrepositoy.save(client);
	}

	@Override
	public Client updateClient(Long id, Client clientUpdate) {
		Client clientExists = clientrepositoy.findById(id).orElseThrow(() -> new RuntimeException("ID: " + id + "Not Found"));
		clientExists.setName(clientUpdate.getName());
		clientExists.setEmail(clientUpdate.getEmail());
		return clientrepositoy.save(clientExists);
	}

	@Override
	public void deleteById(Long id) {
		clientrepositoy.deleteById(id);
		
	}

}
