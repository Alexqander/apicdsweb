package com.cds.mx.apicds.admission.controller;

import com.cds.mx.apicds.admission.model.Admissions;
import com.cds.mx.apicds.admission.model.AdmissionsRepository;
import com.cds.mx.apicds.person.model.Person;
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
public class AdmissionService {
    @Autowired
    AdmissionsRepository admissionsRepository;

    //servicio para obtener a todas la convocatorias
    @Transactional
    public ResponseEntity<Message>findAll(){
        return new ResponseEntity<>(new Message("OK",false,admissionsRepository.findAll()), HttpStatus.OK);
    }
    @Transactional
    public ResponseEntity<Message>findById(long id){
        return new ResponseEntity<>(new Message("OK",false,admissionsRepository.findById(id)),HttpStatus.OK);
    }
    @Transactional(rollbackOn = {SQLException.class})
    public ResponseEntity<Message>save(Admissions admissions){

        Optional<Admissions> existsAdmision = admissionsRepository.findByDescription(admissions.getDescription());
        if (existsAdmision.isPresent()){
            return new ResponseEntity<>(new Message("La categoría ya existe",true,null),
                    HttpStatus.BAD_REQUEST);
        }
       Admissions savedAdmisions =admissionsRepository.saveAndFlush(admissions);
        return new ResponseEntity<>(new Message("Convocatoria registrada",false,savedAdmisions),
                HttpStatus.OK);
    }

    @Transactional(rollbackOn = {SQLException.class})
    public ResponseEntity<Message> update(Admissions admissions){
        if (admissionsRepository.existsById(admissions.getId())){
            return new ResponseEntity<>(new Message("Convocatoria Actualizada",false,admissionsRepository.saveAndFlush(admissions)),HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("La Convocatoria no existe",true,null),HttpStatus.BAD_REQUEST);
    }








}
