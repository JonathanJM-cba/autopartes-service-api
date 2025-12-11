package com.example.autopartes_service.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.autopartes_service.dtos.AutoparteRequestDTO;
import com.example.autopartes_service.dtos.AutoparteResponseDTO;
import com.example.autopartes_service.dtos.ResponseDTO;
import com.example.autopartes_service.dtos.StockPaisDTO;
import com.example.autopartes_service.services.interfaces.IAutoparteService;

import jakarta.validation.Valid;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/autopartes")
public class AutoparteController {

    @Autowired
    private final IAutoparteService autoparteService;

    public AutoparteController(IAutoparteService autoparteService) {
        this.autoparteService = autoparteService;
    }

    @GetMapping("/stats/stock-por-pais")
    public ResponseEntity<ResponseDTO> getStockXPais() {
        List<StockPaisDTO> stockPais = autoparteService.stockPorPais();
        return ResponseEntity.ok(new ResponseDTO(stockPais));
    }

    @PostMapping("/")
    public ResponseEntity<ResponseDTO> createAutoparte(@Valid @RequestBody AutoparteRequestDTO autoparte) {
        AutoparteResponseDTO newAutoparte = autoparteService.saveAutoparte(autoparte);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO("Autoparte creada con éxito", newAutoparte));
    }
}
