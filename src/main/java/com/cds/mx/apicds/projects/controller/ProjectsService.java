package com.cds.mx.apicds.projects.controller;
import com.cds.mx.apicds.projects.model.Projects;
import com.cds.mx.apicds.projects.model.ProjectsRepository;
import com.cds.mx.apicds.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.Optional;

@Service
public class ProjectsService {
    @Autowired
    ProjectsRepository projectsRepository;

    @Transactional
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("OK",false,projectsRepository.findAll()), HttpStatus.OK);
    }
    @Transactional
    public ResponseEntity<Message>findById(long id){
        return new ResponseEntity<>(new Message("OK",false,projectsRepository.findById(id)),HttpStatus.OK);
    }
    @Transactional(rollbackOn = {SQLException.class})
    public ResponseEntity<Message>save(Projects projects){

        Optional<Projects> existsProject = projectsRepository.findByName(projects.getName());
        if (existsProject.isPresent()){
            return new ResponseEntity<>(new Message("Este pryecto ya existe",true,null),
                    HttpStatus.BAD_REQUEST);
        }
        Projects savedProjects =projectsRepository.saveAndFlush(projects);
        return new ResponseEntity<>(new Message("Proyecto Guardado",false,savedProjects),
                HttpStatus.OK);
    }

    @Transactional(rollbackOn = {SQLException.class})
    public ResponseEntity<Message> update(Projects projects){
        if (projectsRepository.existsById(projects.getId())){

            return new ResponseEntity<>(new Message("Proyecto Actualizado",false,projectsRepository.saveAndFlush(projects)),HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("El proyecto no existe",true,null),HttpStatus.BAD_REQUEST);
    }

}
