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

import com.dotour.model.Purshace;
import com.dotour.service.PurshaceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/purshace")
public class PurshaceController {

	@Autowired
	private PurshaceService purshaceService;

	@Operation(description = "Compra uma passagem, passe a data da compra, data ida, data de volta e o número do pedido, no client, passe um cliente que já tenha um cadastro para compar a passagem, não esquecendo de informar o id dele, a mesma coisa para o destiny passe um destino que irá ser feito a viagem, informe todos os campos do destiny já cadastrado e o id dele.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Compra realizada com sucesso."),
			@ApiResponse(responseCode = "400", description = "Falha ao realizar a compra.") })
	@PostMapping("/savepurshace")
	public Purshace Buy(@RequestBody Purshace purshace) {
		return purshaceService.savePurshace(purshace);
	}

	@Operation(description = "Lista todas as compras já feitas.")
	@GetMapping("/allpurshaces")
	public List<Purshace> List() {
		return purshaceService.getAllPurshaces();
	}

	@Operation(description = "Busca alguma compra informando o ID.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna a compra buscada pelo ID."),
			@ApiResponse(responseCode = "500", description = "ID informado não existe.")
	})
	@GetMapping("/{id}")
	public ResponseEntity<Purshace> Search(@PathVariable Long id) {
		Purshace purshace = purshaceService.getPurshaceById(id);
		return ResponseEntity.ok(purshace);
	}

	@Operation(description = "Atualiza uma compra passando todos os campos informados.")
	@PutMapping("/{id}")
	public ResponseEntity<Purshace> Update(@PathVariable Long id, @RequestBody Purshace purshaceUpdate) {
		Purshace purshace = purshaceService.getPurshaceById(id);

		purshace.setDatePurshace(purshaceUpdate.getDatePurshace());
		purshace.setDateDeparture(purshaceUpdate.getDateDeparture());
		purshace.setDateReturn(purshaceUpdate.getDateReturn());
		purshace.setNumOrder(purshaceUpdate.getNumOrder());
		purshace.setClient(purshaceUpdate.getClient());
		purshace.setDestiny(purshaceUpdate.getDestiny());

		purshaceService.savePurshace(purshace);

		return ResponseEntity.ok(purshace);
	}

	@Operation(description = "Exclui uma compra pelo ID.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Compra ecluida com sucesso.")
	})
	@DeleteMapping("/{id}")
	public void Delete(@PathVariable Long id) {
		purshaceService.deleteById(id);
	}
}
