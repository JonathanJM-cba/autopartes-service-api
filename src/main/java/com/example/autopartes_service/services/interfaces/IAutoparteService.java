package com.example.autopartes_service.services.interfaces;

import java.util.List;

import com.example.autopartes_service.dtos.StockPaisDTO;

public interface IAutoparteService {
    
    List<StockPaisDTO> stockPorPais();
    
}
