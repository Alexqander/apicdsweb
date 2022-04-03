package com.cds.mx.apicds.admission.controller;
import com.cds.mx.apicds.person.model.Person;
import com.cds.mx.apicds.status.model.Status;

import java.util.List;

public class AdmissionDTO {

    private long id;
    private String description;
    private String startDate;
    private String endDate;
    private List<Person> persons;
    private Status status;

    public AdmissionDTO(String description, String startDate, String endDate, Status status) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public AdmissionDTO(long id, String description, Status status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }

    public AdmissionDTO(String description, String startDate, String endDate, List<Person> persons, Status status) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.persons = persons;
        this.status = status;
    }

    public AdmissionDTO(String description, Status status) {
        this.description = description;
        this.status = status;
    }

    public AdmissionDTO() {
    }

    public AdmissionDTO(long id, String description, String startDate, String endDate, List<Person> persons) {
        this.id = id;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.persons = persons;
    }


    public AdmissionDTO(String description, String startDate, String endDate, List<Person> persons) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.persons = persons;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
