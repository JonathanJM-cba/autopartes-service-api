package com.example.autopartes_service.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "autopartes")
public class Autoparte {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "UUID")
    private UUID id;

    @Column
    private String codigo;

    @Column
    private String descripcion;

    @Column
    private Boolean parteMotor;

    @Column
    private Double precioUnitario;

    @Column
    private int stock;

    @OneToMany(mappedBy = "autoparte", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Auto> autos;

    @OneToMany(mappedBy = "autoparte", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Pais> paises;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
