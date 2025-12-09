package com.example.autopartes_service.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.autopartes_service.dtos.StockPaisDTO;
import com.example.autopartes_service.entities.Autoparte;

public interface IAutoparteRepository extends JpaRepository<Autoparte, UUID>{

    @Query("""
            SELECT new com.example.autopartes_service.dtos.StockPaisDTO(p.nombre, SUM(a.stock))
            FROM Pais p JOIN p.autoparte a
            GROUP BY p.nombre
            """)
    List<StockPaisDTO> obtenerStockPorPais();
}
