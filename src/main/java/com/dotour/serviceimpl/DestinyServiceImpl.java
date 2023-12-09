package com.dotour.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotour.model.Destiny;
import com.dotour.repository.DestinyRepository;
import com.dotour.service.DestinyService;

@Service
public class DestinyServiceImpl implements DestinyService {

    @Autowired
    private DestinyRepository destinyRepository;

    @Override
    public List<Destiny> getAllDestinies() {

        return destinyRepository.findAll();
    }

    @Override
    public Destiny getDestinyById(Long id) {
        
        return destinyRepository.findById(id).orElseThrow(() -> new RuntimeException("ID: " + id + "Not Found"));
    }

    @Override
    public Destiny saveDestiny(Destiny destiny) {
      
        return destinyRepository.save(destiny);
    }

    @Override
    public Destiny updateDestiny(Long id, Destiny destinyUpdate) {
        Destiny destinyExists = destinyRepository.findById(id).orElseThrow(() -> new RuntimeException("ID: " + id + "Not Found"));
        destinyExists.setDestiny(destinyUpdate.getDestiny());
        destinyExists.setLocation(destinyUpdate.getLocation());
        destinyExists.setDescription(destinyUpdate.getDescription());
        destinyExists.setPrice(destinyUpdate.getPrice());
        return destinyRepository.save(destinyExists);
    }

    @Override
    public void deleteById(Long id) {
       destinyRepository.deleteById(id);
    }

}