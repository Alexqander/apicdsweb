package com.cds.mx.apicds.person.controller;
import com.cds.mx.apicds.person.model.Person;
import com.cds.mx.apicds.projects.controller.ProjectsDTO;
import com.cds.mx.apicds.projects.model.Projects;
import com.cds.mx.apicds.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cds/person")
@CrossOrigin(origins = {"*"})
public class PersonController {


    @Autowired
    PersonService personService;


    @GetMapping("/")
    public ResponseEntity<Message> getAll(){
        return personService.findAll();
    }

    @GetMapping("/{dni}")
    public ResponseEntity<Message>getByDni(@PathVariable("dni") String dni){
        return personService.findByDni(dni);
    }
    @PostMapping("/")
    public ResponseEntity<Message>createPerson(@RequestBody PersonDTO personDTO ){
        Person person = new Person(personDTO.getName(),personDTO.getLastname(),personDTO.getMotherslastname()
                ,personDTO.getDni(),personDTO.getEmail(),personDTO.getEmailInstitutional(),personDTO.getCellphone()
                ,personDTO.getPhone(),personDTO.getAddress(),personDTO.getScholl(),personDTO.getPostulation(),personDTO.getAdmission());
        return personService.save(person);
    }

    @PutMapping("/")
    public ResponseEntity<Message>updateAdmision(@RequestBody PersonDTO personDTO){
        Person person = new Person(personDTO.getId(),personDTO.getName(),personDTO.getLastname(),personDTO.getMotherslastname()
                ,personDTO.getDni(),personDTO.getEmail(),personDTO.getEmailInstitutional(),personDTO.getCellphone()
                ,personDTO.getPhone(),personDTO.getAddress(),personDTO.getScholl(),personDTO.getPostulation()
                ,personDTO.getCvFileUrl(),personDTO.getProfileImageUrl(),personDTO.getUser(),personDTO.getStatus()
                ,personDTO.getAdmission(),personDTO.getPersonSkills(),personDTO.getProjects());
        return personService.update(person);
    }








}
