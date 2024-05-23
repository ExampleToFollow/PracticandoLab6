package com.example.practicandolab6.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "dispositivo", schema = "labgtics")
public class Dispositivo {
    @Id
    @Column(name = "iddispositivo", nullable = false)
    private Integer id;

    @Size(max = 45)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @NotNull
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @NotNull
    @Column(name = "disponibles", nullable = false)
    private Integer disponibles;

    @OneToMany(mappedBy = "idDispositivo")
    private Set<Prestamo> prestamos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idDispositivo")
    private Set<Reserva> reservas = new LinkedHashSet<>();

}