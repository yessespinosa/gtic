package org.bedu.gtic.controller;

import org.bedu.gtic.dto.ProjectDTO;
import org.bedu.gtic.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private ProjectService service;
    @Autowired
    public ProjectController(ProjectService service) {
        this.service = service;
    }
    @GetMapping
    public List<ProjectDTO> findAll(){
        return service.findAll();
    }
    @PostMapping
    @ResponseStatus
    public ProjectDTO save(@RequestBody ProjectDTO data){
        return service.save(data);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") long id, @RequestBody ProjectDTO data) throws Exception{
        service.update(id, data);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id) throws Exception{
        service.delete(id);
    }

}
