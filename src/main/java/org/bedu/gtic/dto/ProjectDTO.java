package org.bedu.gtic.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectDTO {
    private long id;
    private String name;
    private Date createdAt;
    private Date updatedAt;
}
