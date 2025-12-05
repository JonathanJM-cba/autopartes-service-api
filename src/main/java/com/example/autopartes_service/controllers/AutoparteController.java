package com.example.autopartes_service.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.autopartes_service.dtos.ResponseDTO;
import com.example.autopartes_service.entities.Autoparte;
import com.example.autopartes_service.services.interfaces.IAutoparteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/autopartes")
public class AutoparteController {

    @Autowired
    private IAutoparteService autoparteService;

    @PostMapping("")
    public ResponseEntity<?> createAutoparte(@RequestBody Autoparte autoparte) {
        try {
            Autoparte newAutoparte = autoparteService.save(autoparte);

            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO("Autoparte creada con éxito", newAutoparte));
        } catch (Exception e) {
            System.out.println("Error al intentar crear la autoparte: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDTO("Error al intentar crear la autoparte"));
        }
    }
    
}
