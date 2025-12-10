package com.example.autopartes_service.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class RequestAutoparteDTO {

    @NotBlank(message = "El código no puede estar vacío")
    private String codigo;

    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;

    @NotBlank(message = "El campo parteMotor no puede estar vacío, debe ser true o false")
    private Boolean parteMotor;

    @NotBlank(message = "El precio unitario no puede estar vacío")
    @Positive(message = "El precio unitario debe ser un valor positivo")
    private Double precioUnitario;

    @NotBlank(message = "El stock no puede estar vacío")
    @Positive(message = "El stock debe ser un valor positivo")
    private int stock;

    @NotBlank(message = "El idAuto no puede estar vacío")
    private UUID idAuto;

    @NotBlank(message = "El idPais no puede estar vacío")
    private UUID idPais;
}
