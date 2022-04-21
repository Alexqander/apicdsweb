package com.cds.mx.apicds.skills.controller;

import com.cds.mx.apicds.person.model.Person;
import com.cds.mx.apicds.skills.model.Skills;
import com.cds.mx.apicds.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cds/skills")
public class SkillsController {

    @Autowired
    SkillsService skillsService;

    @GetMapping("/")
    public ResponseEntity<Message> getAll(){
        return skillsService.findAll();
    }

    @GetMapping("/{description}")
    public ResponseEntity<Message>getById(@PathVariable("description") String description){
        return skillsService.findByDescription(description);
    }
    @PostMapping("/")
    public ResponseEntity<Message>createSkill(@RequestBody SkillsDTO skillsDTO ){
        Skills skill = new Skills(skillsDTO.getDescription());
        return skillsService.save(skill);
    }

    //Aqui se agrega una persona a la lista de personas que dominan esa skil


}
