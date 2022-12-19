package org.bedu.gtic.service;

import org.bedu.gtic.dto.ProjectDTO;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<ProjectDTO> findAll();
    Optional<ProjectDTO> findById(long id);
    ProjectDTO save(ProjectDTO data);
    void update(long id, ProjectDTO data) throws Exception;
    void delete(long id) throws Exception;
}
