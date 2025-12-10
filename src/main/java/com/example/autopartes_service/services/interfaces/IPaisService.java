package com.example.autopartes_service.services.interfaces;

import java.util.UUID;

import com.example.autopartes_service.dtos.PaisResponseDTO;

public interface IPaisService {
    PaisResponseDTO getPaisById(UUID id);
}
