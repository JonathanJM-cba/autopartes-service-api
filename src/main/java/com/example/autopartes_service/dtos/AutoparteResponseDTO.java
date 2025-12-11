package com.example.autopartes_service.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AutoparteResponseDTO {
    private String codigo;
    private String descripcion;
    private Boolean parteMotor;
    private Double precioUnitario;
    private int stock;
    private List<AutoResponseDTO> autos;
    private List<PaisResponseDTO> paises;
}
