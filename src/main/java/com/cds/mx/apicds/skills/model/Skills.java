package com.cds.mx.apicds.skills.model;

import com.cds.mx.apicds.person.model.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_skill")
    private long id;
    @Column
    private String description;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "skills")
    @JsonIgnore
    private Set<Person> persons = new HashSet<>();

    //persons

    public Skills(String description) {
        this.description = description;
    }

    public Skills(long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Skills(long id, String description, Set<Person> persons) {
        this.id = id;
        this.description = description;
        this.persons = persons;
    }

    public Skills(String description, Set<Person> persons) {
        this.description = description;
        this.persons = persons;
    }

    public Skills() {

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

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }
}

