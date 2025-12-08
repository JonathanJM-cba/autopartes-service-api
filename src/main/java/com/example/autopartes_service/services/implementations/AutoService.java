package com.example.autopartes_service.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.autopartes_service.dtos.ModeloAutoDTO;
import com.example.autopartes_service.entities.Auto;
import com.example.autopartes_service.repositories.IAutoRepository;
import com.example.autopartes_service.services.interfaces.IAutoService;

@Service
public class AutoService implements IAutoService{

    @Autowired
    private IAutoRepository autoRepository;

    @Override
    public ModeloAutoDTO getAutoByModel(String modelo) {
        
        Auto auto = autoRepository.findFirstByModelo(modelo).orElseThrow(() -> new RuntimeException("Auto not found"));

        ModeloAutoDTO modeloAutoDTO = new ModeloAutoDTO();
        modeloAutoDTO.setDescripcion(auto.getAutoparte().getDescripcion());
        modeloAutoDTO.setPrecio(auto.getAutoparte().getPrecioUnitario());
        modeloAutoDTO.setStock(auto.getAutoparte().getStock());

        return modeloAutoDTO;
    }
}
