package com.cds.mx.apicds.user.controller;
import com.cds.mx.apicds.person.model.Person;
import com.cds.mx.apicds.person.model.PersonRepository;
import com.cds.mx.apicds.user.model.User;
import com.cds.mx.apicds.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cds/user")
@CrossOrigin(origins = {"*"})
public class UserController {

    @Autowired
    UserService service;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    PersonRepository personRepository;

    @PostMapping("/")
    public ResponseEntity<Message> save(@RequestBody UserDTO userDTO){
        return service.save(new User(userDTO.getUsername(),encoder.encode(userDTO.getPassword()),userDTO.getPerson()));
    }
    @PostMapping("/{id}/cr")
    public ResponseEntity<Message> save(@PathVariable(value = "id")long id){
        Person person = personRepository.findPersonById(id);
        UserDTO nuevo = new UserDTO(person.getEmailInstitutional(), person.getDni());
        return service.acctivateAccount(id,new User(nuevo.getUsername(), encoder.encode(nuevo.getPassword()) ));
    }



}
