package com.cds.mx.apicds.skills.controller;

import com.cds.mx.apicds.person.model.Person;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

public class SkillsDTO {

    private long id;
    private String description;
    private List<Person> personSkills;

    public SkillsDTO(long id, String description, List<Person> personSkills) {
        this.id = id;
        this.description = description;
        this.personSkills = personSkills;
    }

    public void addPerson(Person person){
        this.personSkills.add(person);
    }



    public SkillsDTO(String description) {
        this.description = description;
    }

    public SkillsDTO(String description, List<Person> personSkills) {
        this.description = description;
        this.personSkills = personSkills;
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

    public List<Person> getPersonSkills() {
        return personSkills;
    }

    public void setPersonSkills(List<Person> personSkills) {
        this.personSkills = personSkills;
    }
}
