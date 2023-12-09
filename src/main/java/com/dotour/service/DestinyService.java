package com.dotour.service;

import java.util.List;

import com.dotour.model.Destiny;

public interface DestinyService {
    
    List<Destiny> getAllDestinies();

    Destiny getDestinyById(Long id);

    Destiny saveDestiny(Destiny destiny);

    Destiny updateDestiny(Long id, Destiny destinyUpdate);

    void deleteById(Long id);
}
