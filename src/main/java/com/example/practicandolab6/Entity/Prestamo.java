package com.example.practicandolab6.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "prestamo", schema = "labgtics")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprestamo", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "fechainicio", nullable = false)
    private LocalDate fechaInicio;

    @NotNull
    @Column(name = "fechafin", nullable = false)
    private LocalDate fechaFin;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idalumno", nullable = false)
    private Usuario idAlumno;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "iddispositivo", nullable = false)
    private Dispositivo idDispositivo;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idprofesor", nullable = false)
    private Usuario idProfesor;

}