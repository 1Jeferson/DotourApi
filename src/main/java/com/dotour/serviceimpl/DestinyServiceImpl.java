package com.dotour.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotour.model.Destiny;
import com.dotour.repository.DestinyRepository;
import com.dotour.service.DestinyService;

import jakarta.transaction.Transactional;

@Service
public class DestinyServiceImpl implements DestinyService {

    @Autowired
    private DestinyRepository destinyRepository;

    @Override
    public List<Destiny> getAllDestinies() {

        return destinyRepository.findAll();
    }

    @Override
    @Transactional
    public Destiny getDestinyById(Long id) {
        
        return destinyRepository.findById(id).orElse(null);
    }

    @Override
    public Destiny saveDestiny(Destiny destiny) {
      
        return destinyRepository.save(destiny);
    }

    @Override
    public Destiny updateDestiny(Long id, Destiny destinyUpdate) {
        Destiny destinyExists = destinyRepository.findById(id).orElse(null);
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