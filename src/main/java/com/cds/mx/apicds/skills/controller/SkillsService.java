package com.cds.mx.apicds.skills.controller;

import com.cds.mx.apicds.person.model.PersonRepository;
import com.cds.mx.apicds.projects.model.Projects;
import com.cds.mx.apicds.skills.model.Skills;
import com.cds.mx.apicds.skills.model.SkillsRepository;
import com.cds.mx.apicds.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional
public class SkillsService {
    @Autowired
    SkillsRepository skillsRepository;
    @Autowired
    PersonRepository personRepository;

    @Transactional
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("OK",false,skillsRepository.findAll()), HttpStatus.OK);
    }
    @Transactional
    public ResponseEntity<Message>findByDescription(String description){
        return new ResponseEntity<>(new Message("OK",false,skillsRepository.findByDescription(description)),HttpStatus.OK);
    }
    @Transactional(rollbackOn = {SQLException.class})
    public ResponseEntity<Message>save(Skills skills){

        Optional<Skills> existsSkill = skillsRepository.findByDescription(skills.getDescription());
        if (existsSkill.isPresent()){
            return new ResponseEntity<>(new Message("Esta habilidad ya esta registrada",true,null),
                    HttpStatus.BAD_REQUEST);
        }
        Skills savedSkills =skillsRepository.saveAndFlush(skills);
        return new ResponseEntity<>(new Message("Habilidad Guardada",false,savedSkills),
                HttpStatus.OK);
    }

    @Transactional(rollbackOn = {SQLException.class})
    public ResponseEntity<Message> update(Skills skills){
        if (skillsRepository.existsById(skills.getId())){
                return new ResponseEntity<>(new Message("Habilidad Actualizada",false,skillsRepository.saveAndFlush(skills)),HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message(" No se encontro la habilidad",true,null),HttpStatus.BAD_REQUEST);
    }
}
