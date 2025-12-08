package com.example.autopartes_service.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModeloAutoDTO {
    private String descripcion;
    private Double precio;
    private int stock;
}
