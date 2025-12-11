package com.example.autopartes_service.services.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.autopartes_service.dtos.AutoResponseDTO;
import com.example.autopartes_service.dtos.AutoparteRequestDTO;
import com.example.autopartes_service.dtos.AutoparteResponseDTO;
import com.example.autopartes_service.dtos.PaisResponseDTO;
import com.example.autopartes_service.dtos.StockPaisDTO;
import com.example.autopartes_service.entities.Auto;
import com.example.autopartes_service.entities.Autoparte;
import com.example.autopartes_service.entities.Pais;
import com.example.autopartes_service.exceptions.InternalServerErrorException;
import com.example.autopartes_service.repositories.IAutoparteRepository;
import com.example.autopartes_service.services.interfaces.IAutoService;
import com.example.autopartes_service.services.interfaces.IAutoparteService;
import com.example.autopartes_service.services.interfaces.IPaisService;


@Service
public class AutoparteServiceImpl implements IAutoparteService{

    @Autowired
    private IAutoparteRepository autoparteRepository;

    @Autowired
    private IAutoService autoService;

    @Autowired
    private IPaisService paisService;
    

    @Override
    public List<StockPaisDTO> stockPorPais() {
        return autoparteRepository.obtenerStockPorPais();
    }

    @Override
    public AutoparteResponseDTO saveAutoparte(AutoparteRequestDTO autoparte) {
        try {
            Auto auto = autoService.getAutoEntityById(autoparte.getIdAuto());
            Pais pais = paisService.getPaisEntityById(autoparte.getIdPais());

            Autoparte autoparteData = new Autoparte();
            autoparteData.setCodigo(autoparte.getCodigo());
            autoparteData.setDescripcion(autoparte.getDescripcion());
            autoparteData.setParteMotor(autoparte.getParteMotor());
            autoparteData.setPrecioUnitario(autoparte.getPrecioUnitario());
            autoparteData.setStock(autoparte.getStock());
            autoparteData.setAutos(List.of(auto));
            autoparteData.setPaises(List.of(pais));

            Autoparte newAutoparte = autoparteRepository.save(autoparteData);

            List<AutoResponseDTO> autosDto = newAutoparte.getAutos().stream()
                .map(a -> new AutoResponseDTO(a.getMarca(), a.getModelo(), a.getVersion()))
                .collect(Collectors.toList());

            List<PaisResponseDTO> paisesDto = newAutoparte.getPaises().stream()
                .map(p -> new PaisResponseDTO(p.getNombre()))
                .collect(Collectors.toList());

            return new AutoparteResponseDTO(newAutoparte.getCodigo(), newAutoparte.getDescripcion(), newAutoparte.getParteMotor(), newAutoparte.getPrecioUnitario(), newAutoparte.getStock(), autosDto, paisesDto);
        } catch (InternalServerErrorException e) {
            throw new InternalServerErrorException(e.getMessage());
        }
    }
}
