package com.dotour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dotour.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
