package com.cds.mx.apicds.user.controller;

import com.cds.mx.apicds.address.model.Address;
import com.cds.mx.apicds.address.model.AddressRepository;
import com.cds.mx.apicds.person.model.Person;
import com.cds.mx.apicds.person.model.PersonRepository;
import com.cds.mx.apicds.status.model.Status;
import com.cds.mx.apicds.status.model.StatusRepository;
import com.cds.mx.apicds.user.model.User;
import com.cds.mx.apicds.user.model.UserRepository;
import com.cds.mx.apicds.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    StatusRepository statusRepository;



    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message>save(User user){
        Status status = statusRepository.findStatusById(1);
        System.out.println("aqui llega el usuario " + user.getUsername() + " " + user.getPerson());
        if (userRepository.existsByUsername(user.getUsername()))
            return new ResponseEntity<>(new Message("el Usuario ya existe",true,null), HttpStatus.BAD_REQUEST);

        if (user.getPerson().getAddress()!=null){
            Address address = addressRepository.saveAndFlush(user.getPerson().getAddress());
            Person person =user.getPerson();
            person.setAddress(address);
            person.setStatus(status);
            person = personRepository.saveAndFlush(person);
            user.setPerson(person);
        }
        Person person =user.getPerson();
        person = personRepository.saveAndFlush(person);
        person.setStatus(status);
        user.setPerson(person);

        return new ResponseEntity<>(new Message("OK",false,userRepository.saveAndFlush(user)), HttpStatus.OK);
    }
    @Transactional(readOnly = true)
    public Optional<User>getByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message>acctivateAccount(long idperson,User user){
        Status status = statusRepository.findStatusById(1);
        Person person = personRepository.findPersonById(idperson);
        if (person!=null){
            if (userRepository.existsByUsername(person.getEmailInstitutional()))
                return new ResponseEntity<>(new Message("el Usuario ya existe",true,null), HttpStatus.BAD_REQUEST);
            person.setStatus(status);
            user.setPerson(person);
            return new ResponseEntity<>(new Message("ok",false,userRepository.saveAndFlush(user)),HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("Esta persona no existe",true,null), HttpStatus.BAD_REQUEST);
    }

}
