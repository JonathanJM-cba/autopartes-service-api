package com.example.autopartes_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.autopartes_service.dtos.ModeloAutoDTO;
import com.example.autopartes_service.dtos.ResponseDTO;
import com.example.autopartes_service.services.interfaces.IAutoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/autos")
public class AutoControllers {

    @Autowired
    private IAutoService autoService;

    @GetMapping("/modelo")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    public ResponseEntity<?> getAutoByModel(@RequestParam String modelo) {
        try {
            ModeloAutoDTO modeloAutoDTO = autoService.getAutoByModel(modelo);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(modeloAutoDTO));
        } catch (Exception e) {
            System.out.println("Error al intentar obtener auto por modelo: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDTO("ERROR_GET_AUTO_BY_MODEL"));
        }
    }
}
