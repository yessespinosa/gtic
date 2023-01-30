package org.bedu.gtic.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="persons")
// @RestResource(exported=false) javaII sesion 2 ejemplo 2
// exported = false sirve para que esta entidad no sea tratada por Data Rest y no sera accesible a traves de ninguna API.
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="name", nullable = false)
    @NotEmpty(message = "El nombre de la persona no puede ser vacío")
    @Size(min = 5, max = 100, message = "El nombre de la persona debe tener al menos 5 letras y ser menor a 100 caracteres")
    private String name;
    @Column(name="device")
    private String device;
    @Column(name="inventory")
    private String inventory;

    @ManyToOne
    @JoinColumn(name="project_id", referencedColumnName = "id", nullable = false)
    private Project project;
}
