package org.bedu.gtic.service.impl;

import org.bedu.gtic.dto.ProjectDTO;
import org.bedu.gtic.entity.Project;
import org.bedu.gtic.mapper.ProjectMapper;
import org.bedu.gtic.repository.ProjectRepository;
import org.bedu.gtic.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {
    private ProjectMapper mapper;
    private ProjectRepository repository;
    @Autowired
    public ProjectServiceImpl(ProjectMapper mapper, ProjectRepository repository){
        this.mapper = mapper;
        this.repository = repository;
    }
    public List<ProjectDTO> findAll(){
        List<Project> projects = repository.findAll();
        List<ProjectDTO> mapperProjects = new LinkedList<>();
        for(Project p: projects){
            mapperProjects.add(mapper.toDTO(p));
        }
        return mapperProjects;
    }

    @Override
    public Optional<ProjectDTO> findById(long id) {
        return null;
    }

    @Override
    public ProjectDTO save(ProjectDTO data) {
        Project entity = mapper.toEntity(data);
        return mapper.toDTO(repository.save(entity));
    }
    public void update(long id, ProjectDTO data) throws Exception {
        Optional<Project> result = repository.findById(id);
        if(result.isEmpty()){
            throw new Exception("No hay proyectos existentes");
        }
        Project project = result.get();
        project.setName(data.getName());
        repository.save(project);
    }
    public void delete(long id) throws Exception {
        Optional<Project> result = repository.findById(id);
        if(result.isEmpty()){
            throw new Exception("El proyecto seleccionado no existe");
        }
        repository.deleteById(id);
    }
}
