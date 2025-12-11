package com.example.autopartes_service.services.interfaces;

import java.util.UUID;

import com.example.autopartes_service.dtos.AutoResponseDTO;
import com.example.autopartes_service.dtos.ModeloAutoDTO;
import com.example.autopartes_service.entities.Auto;

public interface IAutoService {

    Auto getAutoEntityById(UUID id);

    AutoResponseDTO getAutoById(UUID id);

    ModeloAutoDTO getAutoByModel(String modelo);
}
