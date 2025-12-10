package com.example.autopartes_service.services.implementations;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.autopartes_service.dtos.PaisResponseDTO;
import com.example.autopartes_service.entities.Pais;
import com.example.autopartes_service.exceptions.InternalServerErrorException;
import com.example.autopartes_service.exceptions.NotFoundException;
import com.example.autopartes_service.repositories.IPaisRepository;
import com.example.autopartes_service.services.interfaces.IPaisService;

@Service
public class PaisService implements IPaisService{

    @Autowired
    private IPaisRepository paisRepository;

    @Override
    public PaisResponseDTO getPaisById(UUID id) {
        try {
            Pais pais = paisRepository.findById(id).orElseThrow(() -> new NotFoundException("No se ha encontrado un país con el ID: " + id));

            return new PaisResponseDTO(pais.getNombre());
        }  
        catch (NotFoundException e) {
            throw new NotFoundException(e.getMessage());
        }
        catch (InternalServerErrorException e) {
            throw new InternalServerErrorException(e.getMessage());
        }
    }
}
