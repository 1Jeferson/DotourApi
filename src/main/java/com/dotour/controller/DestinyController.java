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

import com.dotour.model.Destiny;
import com.dotour.service.DestinyService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/destiny")
public class DestinyController {

    @Autowired
    private DestinyService destinyService;

    
    @Operation(description = "Cria um novo destino informando todos os campos.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Destino criado com sucesso."),
        @ApiResponse(responseCode = "400", description = "Falha ao cadastrar um novo destino.")
    })
    @PostMapping("/savedestiny")
    public Destiny createDestiny(@RequestBody Destiny destiny) {
        return destinyService.saveDestiny(destiny);
    }


    @Operation(description = "Obtém todos os destinos já cadastrados.")
    @GetMapping("/alldestinies")
    public List<Destiny> getAllDestinies() {
        return destinyService.getAllDestinies();
    }


    @Operation(description = "Busca o destino pelo ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Retorna o destino buscado."),
        @ApiResponse(responseCode = "400", description = "ID informado não existe.")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Destiny> getDestinyById(@PathVariable Long id) {
        Destiny destiny = destinyService.getDestinyById(id);
        return ResponseEntity.ok(destiny);
    }


    @Operation(description = "Atualiza um destino existente pelo ID, passando todos os campos que irão ser atualizados.")
    @PutMapping("/{id}")
    public ResponseEntity<Destiny> updateDestiny(@PathVariable Long id, @RequestBody Destiny destinyUpdate) {
        Destiny destiny = destinyService.getDestinyById(id);

        destiny.setDestiny(destinyUpdate.getDestiny());
        destiny.setLocation(destinyUpdate.getLocation());
        destiny.setDescription(destinyUpdate.getDescription());
        destiny.setPrice(destinyUpdate.getPrice());

        destinyService.saveDestiny(destiny);

        return ResponseEntity.ok(destiny);
    }



    @Operation(description = "Exclui um destino pelo ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Destino excluido pelo ID com sucesso.")
    })
    @DeleteMapping("/{id}")
    public void deleteDestiny(@PathVariable Long id) {
        destinyService.deleteById(id);
    }
    
}
