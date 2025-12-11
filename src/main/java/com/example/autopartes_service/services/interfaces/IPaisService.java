package com.example.autopartes_service.services.interfaces;

import java.util.UUID;

import com.example.autopartes_service.dtos.PaisResponseDTO;
import com.example.autopartes_service.entities.Pais;

public interface IPaisService {

    Pais getPaisEntityById(UUID id);

    PaisResponseDTO getPaisById(UUID id);
}
