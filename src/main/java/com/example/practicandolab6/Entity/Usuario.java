package com.example.practicandolab6.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "usuario", schema = "labgtics")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario", nullable = false)
    private Integer id;

    @Size(max = 45)
    @Column(name = "correo", length = 45)
    private String correo;

    @Size(max = 200)
    @Column(name = "password", length = 200)
    private String password;

    @Size(max = 45)
    @Column(name = "nombre", length = 45)
    private String nombre;

    @Size(max = 45)
    @Column(name = "apellido", length = 45)
    private String apellido;

    @Column(name = "estado")
    private Byte estado;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idrol", nullable = false)
    private Rol idRol;

    @OneToMany(mappedBy = "idAlumno")
    private Set<Prestamo> prestamos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idAlumno")
    private Set<Reserva> reservas = new LinkedHashSet<>();

}