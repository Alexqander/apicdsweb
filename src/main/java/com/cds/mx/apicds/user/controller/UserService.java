package com.cds.mx.apicds.user.controller;

import com.cds.mx.apicds.person.model.Person;
import com.cds.mx.apicds.person.model.PersonRepository;
import com.cds.mx.apicds.user.model.User;
import com.cds.mx.apicds.user.model.UserRepository;
import com.cds.mx.apicds.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PersonRepository personRepository;

    @Transactional(readOnly = false)
    public ResponseEntity<Message>save(User user){
        if (userRepository.existsByUsername(user.getUsername()))
            return new ResponseEntity<>(new Message("el Usuario ya existe",true,null), HttpStatus.BAD_REQUEST);
        if (userRepository.existsByPersonDni(user.getPerson().getDni()))
            return new ResponseEntity<>(new Message("La persona ya existe",true,null), HttpStatus.BAD_REQUEST);
        Person person =user.getPerson();
               person = personRepository.saveAndFlush(person);
        user.setPerson(person);
        return new ResponseEntity<>(new Message("OK",false,userRepository.saveAndFlush(user)), HttpStatus.OK);
    }
    @Transactional(readOnly = true)
    public Optional<User>getByUsername(String username){
        return userRepository.findByUsername(username);
    }

}
