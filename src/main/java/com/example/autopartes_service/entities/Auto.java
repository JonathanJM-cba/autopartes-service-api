package com.example.autopartes_service.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "autos")
public class Auto {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "UUID")
    private UUID id;

    @Column(length = 20, nullable = false)
    private String marca;

    @Column(length = 20, nullable = false)
    private String modelo;

    @Column(length = 20, nullable = false)
    private String version;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "autoparte_id", nullable = true)
    @ToString.Exclude
    private Autoparte autoparte;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
