package com.cds.mx.apicds.skills.controller;

import com.cds.mx.apicds.person.model.Person;

import javax.persistence.*;
import java.util.List;

public class SkillsDTO {


    private long id;
    private String description;

    private List<Person>persons;

    public SkillsDTO(String description) {
        this.description = description;
    }

    public SkillsDTO(long id, String description, List<Person> persons) {
        this.id = id;
        this.description = description;
        this.persons = persons;
    }

    public SkillsDTO(long id, String description) {
        this.id = id;
        this.description = description;
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

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
