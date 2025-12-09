package com.example.autopartes_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StockPaisDTO {
    private String pais;
    private Long stock;
}
