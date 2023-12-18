package com.dotour.service;

import java.util.List;

import com.dotour.model.Purshace;

public interface PurshaceService {

	List<Purshace> getAllPurshaces();
	
	Purshace getPurshaceById(Long id);
	
	Purshace savePurshace(Purshace purshace);
	
	Purshace UpdatePurshace(Long id, Purshace purshaceUpdate);
	
	void deleteById(Long id);
}
