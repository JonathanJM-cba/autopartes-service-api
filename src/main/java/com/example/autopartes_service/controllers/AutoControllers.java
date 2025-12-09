package com.example.autopartes_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.autopartes_service.dtos.ModeloAutoDTO;
import com.example.autopartes_service.dtos.ResponseDTO;
import com.example.autopartes_service.services.interfaces.IAutoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/autos")
public class AutoControllers {

    @Autowired
    private IAutoService autoService;

    @GetMapping("/modelo/{modelo}")
    public ResponseEntity<ResponseDTO> getAutoByModel(@PathVariable String modelo) {
       ModeloAutoDTO modeloAutoDTO = autoService.getAutoByModel(modelo);
       return ResponseEntity.ok(new ResponseDTO(modeloAutoDTO));
    }
}
