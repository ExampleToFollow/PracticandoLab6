package com.example.practicandolab6.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "rol", schema = "labgtics")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrol", nullable = false)
    private Integer id;

    @Size(max = 45)
    @Column(name = "nombre", length = 45)
    private String nombre;

    @OneToMany(mappedBy = "idRol")
    private Set<Usuario> usuarios = new LinkedHashSet<>();

}