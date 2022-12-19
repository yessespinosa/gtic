package org.bedu.gtic.entity;

import jakarta.persistence.*;
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
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="device")
    private String device;
    @Column(name="inventory")
    private String inventory;

    @ManyToOne
    @JoinColumn(name="project_id", referencedColumnName = "id", nullable = false)
    private Project project;
}
