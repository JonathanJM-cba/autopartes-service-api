package com.example.autopartes_service.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.autopartes_service.entities.Pais;

public interface IPaisRepository extends JpaRepository<Pais, UUID>{

}
