package com.cds.mx.apicds.status.model;

import com.cds.mx.apicds.admission.model.Admissions;
import com.cds.mx.apicds.person.model.Person;
import com.cds.mx.apicds.projects.model.Projects;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String description;

    @OneToMany(mappedBy = "status")
    @JsonIgnore
    private List<Person>persons;
    @OneToMany(mappedBy = "status")
    @JsonIgnore
    private List<Projects>projects;
    @OneToMany(mappedBy = "status")
    @JsonIgnore
    private List<Admissions>admissions;

    public List<Projects> getProjects() {
        return projects;
    }

    public void setProjects(List<Projects> projects) {
        this.projects = projects;
    }

    public List<Admissions> getAdmissions() {
        return admissions;
    }

    public void setAdmissions(List<Admissions> admissions) {
        this.admissions = admissions;
    }

    public Status() {
    }

    public Status(Long id, String description, List<Person> persons) {
        this.id = id;
        this.description = description;
        this.persons = persons;
    }

    public Status(String description, List<Person> persons) {
        this.description = description;
        this.persons = persons;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
