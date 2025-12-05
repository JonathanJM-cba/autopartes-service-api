package com.example.autopartes_service.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.autopartes_service.entities.Autoparte;
import com.example.autopartes_service.repositories.IAutoparteRepository;
import com.example.autopartes_service.services.interfaces.IAutoparteService;

@Service
public class AutoparteServiceImpl implements IAutoparteService{

    @Autowired
    private IAutoparteRepository autoparteRepository;

    @Override
    public Autoparte save(Autoparte autoparte) {
        return autoparteRepository.save(autoparte);
    }
}
