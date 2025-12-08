package com.example.autopartes_service.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {
    private String message;
    private Object data;

    public ResponseDTO(String message) {
        this.message = message;
    }

    public ResponseDTO(Object data) {
        this.data = data;
    }

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
