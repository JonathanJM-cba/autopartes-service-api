package com.example.autopartes_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorResponseDTO {
    private int code;
    private String error;
    private String message;
    private String path;
}
