package com.dotour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dotour.model.Client;
import com.dotour.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

	
	@Autowired
	private ClientService clientService;
	
	
	@PostMapping("/saveclient")
	public Client createClient(@RequestBody Client client) {
		return clientService.saveClient(client);
	}
	
	@GetMapping("/allclients")
	public List<Client> getAllClients() {
		return clientService.getAllClients();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable Long id) {
		Client client = clientService.getClientById(id);
		return ResponseEntity.ok(client);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client clientUpdate) {
		Client client = clientService.getClientById(id);
		
		client.setName(clientUpdate.getName());
		client.setEmail(clientUpdate.getEmail());
		client.setPassword(clientUpdate.getPassword());
		
		clientService.saveClient(client);
		
		return ResponseEntity.ok(client);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteClient(@PathVariable Long id) {
		clientService.deleteById(id);
	}
	
	
	
}
