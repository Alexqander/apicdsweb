package com.cds.mx.apicds.person.controller;
import com.cds.mx.apicds.person.model.Person;
import com.cds.mx.apicds.skills.model.Skills;
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
    @GetMapping("/{id}")
    public ResponseEntity<Message>getByDni(@PathVariable("id") long id){
        return personService.findPerson(id);
    }

    @PostMapping("/")
    public ResponseEntity<Message>createPerson(@RequestBody PersonDTO personDTO ){
        Person person = new Person(personDTO.getName(),personDTO.getLastname(),personDTO.getMotherslastname()
                ,personDTO.getDni(),personDTO.getEmail(),personDTO.getEmailInstitutional(),personDTO.getCellphone()
                ,personDTO.getPhone(),personDTO.getAddress(),personDTO.getScholl(),personDTO.getPostulation(),
                personDTO.getCvFileUrl(),
                personDTO.getAdmission());
        return personService.save(person);
    }
    @PutMapping("/{id}/mod")
    public ResponseEntity<Message> modificar(@PathVariable(value = "id")long id,@RequestBody PersonDTO personDTO) {
        Person person = new Person(personDTO.getName(),personDTO.getLastname(),personDTO.getMotherslastname()
                ,personDTO.getDni(),personDTO.getEmail(),personDTO.getEmailInstitutional(),personDTO.getCellphone()
                ,personDTO.getPhone(),personDTO.getAddress(),personDTO.getScholl(),personDTO.getPostulation(),
                personDTO.getCvFileUrl(),
                personDTO.getAdmission());
        return personService.modificar(id,person);
    }
    @PutMapping("/{id}/projects/{pro}")
    public ResponseEntity<Message> addProject(@PathVariable(value = "id")long id,@PathVariable(value = "pro")long pro) {
        return personService.addProject(id,pro);
    }
    @PutMapping("/{id}/skills")
    public ResponseEntity<Message> addSkill(@PathVariable(value = "id")long id,@RequestBody Skills skill) {
        return personService.addSkill(id,skill);
    }








}
