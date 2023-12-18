package com.dotour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dotour.model.Destiny;

@Repository
public interface DestinyRepository extends JpaRepository<Destiny, Long> {

}
