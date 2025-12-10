package com.example.autopartes_service.services.interfaces;

import java.util.UUID;

import com.example.autopartes_service.dtos.AutoResponseDTO;
import com.example.autopartes_service.dtos.ModeloAutoDTO;

public interface IAutoService {

    AutoResponseDTO getAutoById(UUID id);

    ModeloAutoDTO getAutoByModel(String modelo);
}
