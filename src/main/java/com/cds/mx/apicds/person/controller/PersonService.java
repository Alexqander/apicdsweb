package com.cds.mx.apicds.person.controller;

import com.cds.mx.apicds.address.model.Address;
import com.cds.mx.apicds.address.model.AddressRepository;
import com.cds.mx.apicds.person.model.Person;
import com.cds.mx.apicds.person.model.PersonRepository;
import com.cds.mx.apicds.projects.model.Projects;
import com.cds.mx.apicds.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    PersonRepository personRepository;

    @Transactional
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("OK",false,personRepository.findAll()), HttpStatus.OK);
    }
    //en este metodo se consulta la persona por medio de su matricula estudiantil
    @Transactional
    public ResponseEntity<Message>findByDni(String dni){
        return new ResponseEntity<>(new Message("OK",false,personRepository.findByDni(dni)),HttpStatus.OK);
    }
    //metodo para hacer el regisgtro de una nueva persona
    @Transactional(rollbackOn = {SQLException.class})
    public ResponseEntity<Message>save(Person person){

        //aqui se valida que la persona no este registrada por diversos campos unicos
        //Verificar por Matricula
        Optional<Person> existsPerson = personRepository.findByDni(person.getDni());
        Optional<Person> existsPersonEmail = personRepository.findByEmail(person.getEmail());
        Optional<Person> existsPersonEmailIns = personRepository.findByEmailInstitutional(person.getEmailInstitutional());
        if (existsPerson.isPresent()){
            return new ResponseEntity<>(new Message("Ya existe una persona registrada con la misma matricula",true,null),
                    HttpStatus.BAD_REQUEST);
        }if (existsPersonEmail.isPresent()){
            return new ResponseEntity<>(new Message("Este Correo ya ah sido registrado",true,null),
                    HttpStatus.BAD_REQUEST);
        }if (existsPersonEmailIns.isPresent()){
            return new ResponseEntity<>(new Message("Este correo Institucional ya ha sido registrado",true,null),
                    HttpStatus.BAD_REQUEST);
        }

        //Guardo la direcion y la seteo a persona
        Address address = addressRepository.saveAndFlush(person.getAddress());
        person.setAddress(address);
        return new ResponseEntity<>(new Message("OK",false,personRepository.saveAndFlush(person)),
                HttpStatus.OK);
    }



    @Transactional(rollbackOn = {SQLException.class})
    public ResponseEntity<Message> update(Person person){
        System.out.println(person.getId());
        System.out.println(personRepository.existsById(person.getId()));
        if (personRepository.existsById(person.getId())){
            return new ResponseEntity<>(new Message("OK",false,personRepository.saveAndFlush(person)),HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("La persona no existe",true,null),HttpStatus.BAD_REQUEST);
    }



}

