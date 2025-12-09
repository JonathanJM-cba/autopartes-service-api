package com.example.autopartes_service.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.autopartes_service.dtos.ResponseDTO;
import com.example.autopartes_service.dtos.StockPaisDTO;
import com.example.autopartes_service.services.interfaces.IAutoparteService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/autopartes")
public class AutoparteController {

    @Autowired
    private IAutoparteService autoparteService;

    @GetMapping("/stats/stock-por-pais")
    public ResponseEntity<ResponseDTO> getStockXPais() {
        List<StockPaisDTO> stockPais = autoparteService.stockPorPais();
        return ResponseEntity.ok(new ResponseDTO(stockPais));
    }
    
    
}
