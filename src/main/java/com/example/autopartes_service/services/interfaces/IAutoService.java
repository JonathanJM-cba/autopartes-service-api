package com.example.autopartes_service.services.interfaces;

import com.example.autopartes_service.dtos.ModeloAutoDTO;

public interface IAutoService {
    ModeloAutoDTO getAutoByModel(String modelo);
}
