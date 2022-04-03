package com.cds.mx.apicds.skills.model;

import com.cds.mx.apicds.person.model.Person;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skills_id")
    private long id;
    @Column
    private String description;

    @ManyToMany
    @JsonBackReference
    @JoinTable(name = "person_skills",
    joinColumns = @JoinColumn(name = "skills_id",referencedColumnName = "skills_id"),
    inverseJoinColumns = @JoinColumn(name = "person_id",referencedColumnName = "person_id"))
    private List<Person>personSkills;

    public void addPerson(Person person){
        this.personSkills.add(person);
    }

    public Skills() {
    }


    public Skills(long id, List<Person> personSkills) {
        this.id = id;
        this.personSkills = personSkills;
    }

    public Skills(long id, String description, List<Person> personSkills) {
        this.id = id;
        this.description = description;
        this.personSkills = personSkills;
    }

    public Skills(String description, List<Person> personSkills) {
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
