package com.example.autopartes_service.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.autopartes_service.dtos.StockPaisDTO;
import com.example.autopartes_service.repositories.IAutoparteRepository;
import com.example.autopartes_service.services.interfaces.IAutoparteService;


@Service
public class AutoparteServiceImpl implements IAutoparteService{

    @Autowired
    private IAutoparteRepository autoparteRepository;

    @Override
    public List<StockPaisDTO> stockPorPais() {
        return autoparteRepository.obtenerStockPorPais();
    }
}
