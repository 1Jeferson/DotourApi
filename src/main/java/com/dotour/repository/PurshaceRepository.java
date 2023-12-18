package com.dotour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dotour.model.Purshace;

@Repository
public interface PurshaceRepository extends JpaRepository<Purshace, Long> {

}
