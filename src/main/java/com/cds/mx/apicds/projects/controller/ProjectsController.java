package com.cds.mx.apicds.projects.controller;


import com.cds.mx.apicds.projects.model.Projects;
import com.cds.mx.apicds.status.model.Status;
import com.cds.mx.apicds.status.model.StatusRepository;
import com.cds.mx.apicds.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cds/proyectos")
@CrossOrigin(origins = {"*"})
public class ProjectsController {

    @Autowired
    ProjectsService projectsService;
    @Autowired
    StatusRepository statusRepository;

    @GetMapping("/")
    public ResponseEntity<Message> getAll(){
        return projectsService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Message>getById(@PathVariable("id") long id){
        return projectsService.findById(id);
    }
    @PostMapping("/")
    public ResponseEntity<Message>createAdmission(@RequestBody ProjectsDTO projectsDTO ){
        Status status = statusRepository.findStatusById(1);


        Projects projects = new Projects(projectsDTO.getName(),projectsDTO.getDescription(),status);
        return projectsService.save(projects);
    }

    @PutMapping("/")
    public ResponseEntity<Message>updateAdmision(@RequestBody ProjectsDTO projectsDTO){
        Projects projects = new Projects(projectsDTO.getId(),projectsDTO.getName(),projectsDTO.getDescription(),projectsDTO.getProgress(),projectsDTO.getStatus());
        return projectsService.update(projects);
    }

}
