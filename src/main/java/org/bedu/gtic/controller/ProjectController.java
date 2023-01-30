package org.bedu.gtic.controller;

import jakarta.validation.Valid;
import org.bedu.gtic.dto.ProjectDTO;
import org.bedu.gtic.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private ProjectService service;
    @Autowired
    public ProjectController(ProjectService service) {
        this.service = service;
    }
    @GetMapping("/inicio")
    /*public List<ProjectDTO> findAll() {
        return service.findAll();
    }*/
    public String inicio(){
        return "Pantalla de inicio";
    }
    @PostMapping("/{projectId}")
    public void getProjectDTO(@PathVariable long projectId){
        if(projectId == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El id del proyecto no puede ser cero.");
        }
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
    @PostMapping("/save")
    public ResponseEntity<Void> save(@Valid @RequestBody ProjectDTO data) {
        service.save(data);
        return ResponseEntity.created(URI.create("1")).build();
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") long id, @RequestBody ProjectDTO data) throws Exception {
        service.update(id, data);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id) throws Exception {
        service.delete(id);
    }
}