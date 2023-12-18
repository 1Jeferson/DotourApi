package com.dotour.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotour.model.Purshace;
import com.dotour.repository.PurshaceRepository;
import com.dotour.service.PurshaceService;

import jakarta.transaction.Transactional;

@Service
public class PurshaceServiceImpl implements PurshaceService {

	@Autowired
	private PurshaceRepository purshaceRepository;

	@Override
	public List<Purshace> getAllPurshaces() {

		return purshaceRepository.findAll();
	}

	@Override
	@Transactional
	public Purshace getPurshaceById(Long id) {

		return purshaceRepository.findById(id).orElse(null);
	}

	@Override
	public Purshace savePurshace(Purshace purshace) {

		return purshaceRepository.save(purshace);
	}

	@Override
	public Purshace UpdatePurshace(Long id, Purshace purshaceUpdate) {
		Purshace purshaceExists = purshaceRepository.findById(id).orElse(null);
		purshaceExists.setDatePurshace(purshaceUpdate.getDatePurshace());
		purshaceExists.setClient(purshaceUpdate.getClient());
		purshaceExists.setDestiny(purshaceUpdate.getDestiny());
		return purshaceRepository.save(purshaceExists);
	}

	@Override
	public void deleteById(Long id) {
		purshaceRepository.deleteById(id);

	}
}
