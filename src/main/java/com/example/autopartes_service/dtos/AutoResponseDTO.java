package com.example.autopartes_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AutoResponseDTO {
    private String marca;
    private String modelo;
    private String version;
}
