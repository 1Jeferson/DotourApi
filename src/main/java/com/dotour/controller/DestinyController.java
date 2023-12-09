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

@RestController
@RequestMapping("/destiny")
public class DestinyController {

    @Autowired
    private DestinyService destinyService;

    
    @PostMapping("/savedestiny")
    public Destiny createDestiny(@RequestBody Destiny destiny) {
        return destinyService.saveDestiny(destiny);
    }


    @GetMapping("/alldestinies")
    public List<Destiny> getAllDestinies() {
        return destinyService.getAllDestinies();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Destiny> getDestinyById(@PathVariable Long id) {
        Destiny destiny = destinyService.getDestinyById(id);
        return ResponseEntity.ok(destiny);
    }


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


    @DeleteMapping("/{id}")
    public void deleteDestiny(@PathVariable Long id) {
        destinyService.deleteById(id);
    }
    
}
