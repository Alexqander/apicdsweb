package com.cds.mx.apicds.person.controller;
import com.cds.mx.apicds.address.model.Address;
import com.cds.mx.apicds.address.model.AddressRepository;
import com.cds.mx.apicds.person.model.Person;
import com.cds.mx.apicds.person.model.PersonRepository;
import com.cds.mx.apicds.projects.model.Projects;
import com.cds.mx.apicds.projects.model.ProjectsRepository;
import com.cds.mx.apicds.skills.model.Skills;
import com.cds.mx.apicds.skills.model.SkillsRepository;
import com.cds.mx.apicds.status.model.Status;
import com.cds.mx.apicds.status.model.StatusRepository;
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
    ProjectsRepository projectsRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    SkillsRepository skillsRepository;
    @Autowired
    StatusRepository statusRepository;

    @Transactional
    public ResponseEntity<Message> findPerson(long id){
        return new ResponseEntity<>(new Message("OK",false,personRepository.findPersonById(id)), HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<Message> modificar(long id,Person person){

        Person existPerson =personRepository.findPersonById(id);
        if(existPerson!=null){
            existPerson.setCellphone(person.getCellphone());
            existPerson.setEmail(person.getEmail());
            return new ResponseEntity<>(new Message("OK",false,personRepository.saveAndFlush(existPerson)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("error",true,null),
                HttpStatus.BAD_REQUEST);
    }
    @Transactional
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("OK",false,personRepository.findAllByStatus_id(1)), HttpStatus.OK);
    }
    //en este metodo se consulta la persona por medio de su matricula estudiantil
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

        if (person.getAddress()!= null){
            Address address = addressRepository.saveAndFlush(person.getAddress());
            person.setAddress(address);
            Status status = statusRepository.findStatusById(2);
            person.setStatus(status);
        }
        //Guardo la direcion y la seteo a persona

        return new ResponseEntity<>(new Message("OK",false,personRepository.saveAndFlush(person)),
                HttpStatus.OK);
    }

    @Transactional(rollbackOn = {SQLException.class})
    public ResponseEntity<Message> addProject(long idPerson , long idproject){

        Person perPro = personRepository.findPersonById(idPerson);
        Projects proPer = projectsRepository.findById(idproject);
        if (perPro!=null){
            if (proPer!=null){
                perPro.addProject(proPer);
                personRepository.save(perPro);
                return new ResponseEntity<>(new Message("proyecto Guardado",false,proPer.getName()),
                        HttpStatus.OK);
            }
            return new ResponseEntity<>(new Message("el proyecto no existe",true,null),
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new Message("la persona no existe",true,null),
                HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackOn = {SQLException.class})
    public ResponseEntity<Message> addSkill(long idPerson , Skills skill){

        Person perSkill = personRepository.findPersonById(idPerson);
        Skills skillPer = skillsRepository.findByDescription(skill.getDescription());
        if (perSkill!=null){
            if (skillPer!=null){
                perSkill.addSkill(skill);
                personRepository.save(perSkill);
                return new ResponseEntity<>(new Message("Habilidad Guardado",false,skillPer.getDescription()),
                        HttpStatus.OK);
            }
            Skills skillSave = skillsRepository.saveAndFlush(skill);
            perSkill.addSkill(skillSave);
            personRepository.save(perSkill);
            return new ResponseEntity<>(new Message("habilidad registrada",false,skillSave),
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new Message("la persona no existe",true,null),
                HttpStatus.BAD_REQUEST);
    }






}

