package org.bedu.gtic.dto;

import lombok.Data;

@Data
public class PersonDTO {
    private long id;
    private String name;
    private String device;
    private String inventory;
    private ProjectDTO project;
}
