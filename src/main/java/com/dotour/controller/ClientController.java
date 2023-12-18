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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/client")
public class ClientController {

	
	@Autowired
	private ClientService clientService;
	
	@Operation(description = "Cria um novo cliente informando todos os campos.")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Cliente criado com sucesso."),
		@ApiResponse(responseCode = "400", description = "Falha ao cadastrar um cliente.")
	})
	@PostMapping("/saveclient")
	public Client Register(@RequestBody Client client) {
		return clientService.saveClient(client);
	}
	
	@Operation(description = "Obtém todos os clientes cadastrados.")
	@GetMapping("/allclients")
	public List<Client> List() {
		return clientService.getAllClients();
	}
	
	@Operation(description = "Busca o cliente pelo ID.")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Retorna o cliente."),
		@ApiResponse(responseCode = "500", description = "ID informado não existe.")
	})
	@GetMapping("/{id}")
	public ResponseEntity<Client> Search(@PathVariable Long id) {
		Client client = clientService.getClientById(id);
		return ResponseEntity.ok(client);
	}
	
	
	@Operation(description =  "Atualiza um cliente existente pelo ID, passando todos os campos que irão ser atualizados.")
	@PutMapping("/{id}")
	public ResponseEntity<Client> Update(@PathVariable Long id, @RequestBody Client clientUpdate) {
		Client client = clientService.getClientById(id);
		
		client.setName(clientUpdate.getName());
		client.setEmail(clientUpdate.getEmail());
		client.setPassword(clientUpdate.getPassword());
		
		clientService.saveClient(client);
		
		return ResponseEntity.ok(client);
	}
	
	
	@Operation(description = "Exclui um cliente pelo ID.")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Cliente excluido pelo ID com sucesso.")
	})
	@DeleteMapping("/{id}")
	public void Delete(@PathVariable Long id) {
		clientService.deleteById(id);
	}
	
	
	
}
