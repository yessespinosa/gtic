package org.bedu.gtic.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="projects")
// @RestResource(rel="customers", path="customer") javaII sesion 2 ejemplo 2
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PositiveOrZero(message = "El identificador no puede ser un número negativo")
    private long id;
    @Column(name="name", nullable = false)
    @NotEmpty(message = "El nombre del proyecto no puede ser vacío")
    @Size(min = 5, max = 30, message = "El nombre del proyecto debe tener al menos 5 letras y ser menor a 30 caracteres")
    private String name;
    @Column(name="created_at")
    @CreationTimestamp
    private Date createdAt;

    @Column(name="updated_at")
    @UpdateTimestamp
    private Date updatedAt;


    @OneToMany
    @JoinColumn(name="project_id")
    Set<Person> person;


}
