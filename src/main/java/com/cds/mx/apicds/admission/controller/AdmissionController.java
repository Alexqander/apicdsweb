package com.cds.mx.apicds.admission.controller;
import com.cds.mx.apicds.admission.model.Admissions;
import com.cds.mx.apicds.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cds/convocatorias")
@CrossOrigin(origins = {"*"})
public class AdmissionController {
    @Autowired
    AdmissionService admissionService;

    @GetMapping("/")
    public ResponseEntity<Message>getAll(){
        return admissionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message>getById(@PathVariable("id") long id){
        return admissionService.findById(id);
    }

    @GetMapping("/{id}/persons")
    public ResponseEntity<Message>getPersons(@PathVariable("id") long id){
        return admissionService.getPersons(id);
    }
    @PostMapping("/")
    public ResponseEntity<Message>createAdmission(@RequestBody AdmissionDTO admissionDTO ){
        Admissions admissions = new Admissions(admissionDTO.getDescription(), admissionDTO.getStartDate(), admissionDTO.getEndDate(),admissionDTO.getStatus());
        return admissionService.save(admissions);
    }

    @PutMapping("/")
    public ResponseEntity<Message>updateAdmision(@RequestBody AdmissionDTO admissionDTO){
        Admissions admissions = new Admissions(admissionDTO.getId(),admissionDTO.getDescription(),admissionDTO.getStatus());
        return admissionService.update(admissions);
    }
}
