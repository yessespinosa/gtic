package org.bedu.gtic.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EjercicioControllerTest {
    private EjercicioController ejercicioController = new EjercicioController();

    @Test
    @DisplayName("Asignar nombre de dos caracteres a persona")
    void prueba1(){
        ejercicioController.person.setName("Nu");
        assertEquals("Nu",ejercicioController.person.getName());
    }

    @Test
    @DisplayName("Asignar nombre de dos caracteres a proyecto")
    void prueba2(){
        ejercicioController.project.setName("Nu");
        assertEquals("Nu",ejercicioController.project.getName());
    }

    @Test
    @DisplayName("Asignar número negativo a id de proyecto")
    void prueba3(){
        ejercicioController.project.setId(-500);
        assertEquals(-500,ejercicioController.project.getId());
    }

    @Test
    @DisplayName("Asignar número negativo a id de proyectoDTO")
    void prueba4(){
        ejercicioController.projectDTO.setId(-500);
        assertEquals(-500,ejercicioController.projectDTO.getId());
    }

    @Test
    @DisplayName("Asignar fecha actual a proyecto")
    void prueba5(){
        Date date = Date.from(Instant.now());
        ejercicioController.project.setCreatedAt(date);
        assertEquals(date,ejercicioController.project.getCreatedAt());
    }
}