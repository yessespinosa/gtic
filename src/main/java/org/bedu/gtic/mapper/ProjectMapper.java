package org.bedu.gtic.mapper;

import org.bedu.gtic.dto.ProjectDTO;
import org.bedu.gtic.entity.Project;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProjectMapper {
    ProjectDTO toDTO(Project data);
    Project toEntity(ProjectDTO data);
}
