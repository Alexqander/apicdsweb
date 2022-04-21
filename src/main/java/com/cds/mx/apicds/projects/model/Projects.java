package com.cds.mx.apicds.projects.model;
import com.cds.mx.apicds.person.model.Person;
import com.cds.mx.apicds.status.model.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_project")
    private long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private int progress;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "projects")
    @JsonIgnore
    private Set<Person> persons = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    public Projects() {
    }

    public Projects(String name, String description, Status status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public Projects(String name, String description, int progress, Status status) {
        this.name = name;
        this.description = description;
        this.progress = progress;
        this.status = status;
    }

    public Projects(long id, String name, String description, int progress, Status status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.progress = progress;
        this.status = status;
    }

    public Projects(long id, String name, String description, int progress, Set<Person> persons, Status status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.progress = progress;
        this.persons = persons;
        this.status = status;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
