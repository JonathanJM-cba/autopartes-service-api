package com.example.autopartes_service.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.autopartes_service.entities.Auto;

public interface IAutoRepository extends JpaRepository<Auto, UUID>{
    Optional<Auto> findFirstByModelo(String modelo);
}
