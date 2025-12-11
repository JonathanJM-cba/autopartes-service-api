package com.example.autopartes_service.services.implementations;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.autopartes_service.dtos.AutoResponseDTO;
import com.example.autopartes_service.dtos.ModeloAutoDTO;
import com.example.autopartes_service.entities.Auto;
import com.example.autopartes_service.exceptions.InternalServerErrorException;
import com.example.autopartes_service.exceptions.NotFoundException;
import com.example.autopartes_service.repositories.IAutoRepository;
import com.example.autopartes_service.services.interfaces.IAutoService;

@Service
public class AutoService implements IAutoService{

    @Autowired
    private IAutoRepository autoRepository;

    @Override
    public Auto getAutoEntityById(UUID id) {
        Auto auto = autoRepository.findById(id).orElseThrow(() -> new NotFoundException("No se ha encontrado el auto con ID: " + id));
        return auto;
    }

    @Override
    public AutoResponseDTO getAutoById(UUID id) {
        try {
            Auto auto = autoRepository.findById(id).orElseThrow(() -> new NotFoundException("No se ha encontrado el auto con ID: " + id));

            return new AutoResponseDTO(auto.getMarca(), auto.getModelo(), auto.getVersion());   
        } 
        catch (NotFoundException e) {
            throw new NotFoundException(e.getMessage());
        }
        catch (InternalServerErrorException e) {
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @Override
    public ModeloAutoDTO getAutoByModel(String modelo) {
        
        try {
            Auto auto = autoRepository.findFirstByModelo(modelo).orElseThrow(() -> new NotFoundException("No se encontró un auto con el modelo: " + modelo));

            ModeloAutoDTO modeloAutoDTO = new ModeloAutoDTO();
            modeloAutoDTO.setDescripcion(auto.getAutoparte().getDescripcion());
            modeloAutoDTO.setPrecio(auto.getAutoparte().getPrecioUnitario());
            modeloAutoDTO.setStock(auto.getAutoparte().getStock());

            return modeloAutoDTO;
        } 

        catch (NotFoundException e) {
            throw new NotFoundException(e.getMessage());
        }
        catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage());
        }
    }
}
